package app;

import blood_pressure.BloodPressureAlertType;
import blood_pressure.BloodPressureObserver;

public class BloodPressureObserverImpl implements BloodPressureObserver {
    @Override
    public void alert(BloodPressureAlertType bloodPressureAlertType) {
        System.out.println("Blood Pressure Alert: " + bloodPressureAlertType.getValue());
    }
}
