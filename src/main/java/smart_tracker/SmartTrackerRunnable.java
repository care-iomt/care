package smart_tracker;

import data_center.DataCenterConnection;
import java.util.List;

public class SmartTrackerRunnable implements Runnable {
    private final List<SmartTrackerObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long patientId;
    private boolean isRunning;

    public SmartTrackerRunnable(List<SmartTrackerObserver> observerList, Long patientId) {
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
                Thread.sleep(60000);
                final SmartTrackerAlertType alertType = getAlertType();
                if (alertType != null) {
                    dataCenterConnection.getPatientLogController()
                            .saveLog(patientId, "Smart Tracker", "Alert code: "+alertType.getValue());
                    observerList.forEach(observer -> observer.alert(alertType, patientId));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private SmartTrackerAlertType getAlertType() {
        final double rand = Math.random();
        if (rand < 0.925) {
            return null;
        }  else if (rand < 0.95) {
            return SmartTrackerAlertType.FEVER;
        }  else if (rand < 0.975) {
            return SmartTrackerAlertType.TACHYCARDIA;
        } else {
            return SmartTrackerAlertType.BRADYCARDIA;
        }
    }
}
