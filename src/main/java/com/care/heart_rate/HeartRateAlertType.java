package com.care.heart_rate;

public enum HeartRateAlertType {
    MAX(1, "Batimento cardíaco Máximo"),
    MIN(2, "Batimento cardíaco Mínimo");

    private final int value;
    private final String description;

    HeartRateAlertType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
