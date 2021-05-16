package com.care.blood_pressure;

public class BloodPressureConfig {
    private Long patientId;
    private BloodPressureState maxState;
    private BloodPressureState minState;

    public BloodPressureConfig() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public BloodPressureState getMaxState() {
        return maxState;
    }

    public void setMaxState(BloodPressureState maxBloodPressureState) {
        this.maxState = maxBloodPressureState;
    }

    public BloodPressureState getMinState() {
        return minState;
    }

    public void setMinState(BloodPressureState minBloodPressureState) {
        this.minState = minBloodPressureState;
    }
}
