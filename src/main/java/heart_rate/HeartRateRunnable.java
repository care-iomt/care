package heart_rate;

import data_center.DataCenterConnection;

import javax.xml.crypto.Data;
import java.util.List;

public class HeartRateRunnable implements Runnable {
    private final List<HeartRateObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long patientId;
    private boolean isRunning;

    public HeartRateRunnable(List<HeartRateObserver> observerList, Long patientId) {
        this.observerList = observerList;
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.patientId = patientId;
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(5000);
                final HeartRateAlertType alertType = getAlertType();
                if (alertType != null) {
                    dataCenterConnection.getPatientLogController()
                            .saveLog(patientId, "Heart Rate", "Alert code: "+alertType.getValue());
                    observerList.forEach(observer -> observer.alert(alertType, patientId));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private HeartRateAlertType getAlertType() {
        int alertCode = (int) (Math.random() * 21);
        switch (alertCode) {
            case 1: return HeartRateAlertType.MAX;
            case 2: return HeartRateAlertType.MIN;
            default: return null;
        }
    }
}
