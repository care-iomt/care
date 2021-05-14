package smart_tracker;

import data_center.DataCenterConnection;

import java.util.List;

public class SmartTrackerRunnable implements Runnable {
    private final List<SmartTrackerObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long patientId;
    private boolean isRunning;

    public SmartTrackerRunnable(List<SmartTrackerObserver> observerList, DataCenterConnection dataCenterConnection,
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
                final SmartTrackerAlertType alertType = getAlertType();
                if (alertType != null) {
                    dataCenterConnection.getPatientLogController()
                            .saveLog(patientId, "Smart Tracker", "Alert code: "+alertType.getValue());
                    observerList.forEach(observer -> observer.alert(alertType));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private SmartTrackerAlertType getAlertType() {
        int alertCode = (int) (Math.random() * 21);
        switch (alertCode) {
            case 1: return SmartTrackerAlertType.FEVER;
            case 2: return SmartTrackerAlertType.TACHYCARDIA;
            case 3: return SmartTrackerAlertType.BRADYCARDIA;
            default: return null;
        }
    }
}
