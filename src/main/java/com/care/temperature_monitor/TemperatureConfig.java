package com.care.temperature_monitor;

public class TemperatureConfig {
    private Long patientId;
    private TemperatureState minState;
    private TemperatureState maxState;

    public TemperatureConfig() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public TemperatureState getMinState() {
        return minState;
    }

    public void setMinState(TemperatureState minState) {
        this.minState = minState;
    }

    public TemperatureState getMaxState() {
        return maxState;
    }

    public void setMaxState(TemperatureState maxState) {
        this.maxState = maxState;
    }
}
