package com.care.heart_rate;

public interface HeartRateObserver {
    void alert(HeartRateAlertType alertType, Long patientId);
}