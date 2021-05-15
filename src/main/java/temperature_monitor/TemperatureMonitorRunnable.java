package temperature_monitor;

import data_center.DataCenterConnection;
import java.util.List;

public class TemperatureMonitorRunnable implements Runnable {
    private final List<TemperatureObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long patientId;
    private boolean isRunning;

    public TemperatureMonitorRunnable(List<TemperatureObserver> observerList, Long patientId) {
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
                final TemperatureAlertType alertType = getAlertType();
                if (alertType != null) {
                    dataCenterConnection.getPatientLogController()
                            .saveLog(patientId, "Temperature Monitor", "Alert code: "+alertType.getValue());
                    observerList.forEach(observer -> observer.alert(alertType, patientId));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private TemperatureAlertType getAlertType() {
        int alertCode = (int) (Math.random() * 21);
        switch (alertCode) {
            case 1: return TemperatureAlertType.MAX;
            case 2: return TemperatureAlertType.MIN;
            default: return null;
        }
    }
}
