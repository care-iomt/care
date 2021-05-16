package com.care.blood_pressure;

public interface BloodPressureObserver {
    void alert(BloodPressureAlertType bloodPressureAlertType, Long patientId);
}