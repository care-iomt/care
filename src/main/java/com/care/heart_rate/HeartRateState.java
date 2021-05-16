package com.care.heart_rate;

public class HeartRateState {
    private Integer heartRate;

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return String.valueOf(heartRate);
    }
}
