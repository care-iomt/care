package com.care.smart_tracker;

public interface SmartTrackerObserver {
    void alert(SmartTrackerAlertType alertType, Long patientId);
}