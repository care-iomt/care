package blood_pressure;

public interface BloodPressureObserver {
    void alert(BloodPressureAlertType bloodPressureAlertType);
}