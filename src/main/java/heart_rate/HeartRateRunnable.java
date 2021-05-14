package heart_rate;

import data_center.DataCenterConnection;

import java.util.List;

public class HeartRateRunnable implements Runnable {
    private final List<HeartRateObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long patientId;
    private boolean isRunning;

    public HeartRateRunnable(List<HeartRateObserver> observerList, DataCenterConnection dataCenterConnection,
                             Long patientId) {
        this.observerList = observerList;
        this.dataCenterConnection = dataCenterConnection;
        this.patientId = patientId;
        isRunning = true;
    }

    public void stop() {
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
                    observerList.forEach(observer -> observer.alert(alertType));
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
