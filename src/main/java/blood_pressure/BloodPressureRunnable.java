package blood_pressure;

import data_center.DataCenterConnection;

import java.util.List;

public class BloodPressureRunnable implements Runnable {
    private final List<BloodPressureObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long patientId;
    private boolean isRunning;

    public BloodPressureRunnable(List<BloodPressureObserver> observerList, DataCenterConnection dataCenterConnection,
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
                final BloodPressureAlertType alertType = getAlertType();
                if (alertType != null) {
                    dataCenterConnection.getPatientLogController()
                            .saveLog(patientId, "Blood Pressure", "Alert ("+alertType.getValue()+"): "+
                                    alertType);
                    observerList.forEach(observer -> observer.alert(alertType));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private BloodPressureAlertType getAlertType() {
        int alertCode = (int) (Math.random() * 21);
        switch (alertCode) {
            case 1: return BloodPressureAlertType.MAX_DIASTOLIC;
            case 2: return BloodPressureAlertType.MIN_DIASTOLIC;
            case 3: return BloodPressureAlertType.MAX_SYSTOLIC;
            case 4: return BloodPressureAlertType.MIN_SYSTOLIC;
            default: return null;
        }
    }
}
