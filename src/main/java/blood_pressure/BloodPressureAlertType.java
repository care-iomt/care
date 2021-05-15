package blood_pressure;

public enum BloodPressureAlertType {
    MAX_DIASTOLIC(1, "Diástole Máxima"),
    MIN_DIASTOLIC(2, "Diástole Mínima"),
    MAX_SYSTOLIC(3, "Sístole Máxima"),
    MIN_SYSTOLIC(4, "Sístole Mínima");

    private final int value;
    private final String description;

    BloodPressureAlertType(int value, String description) {
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
