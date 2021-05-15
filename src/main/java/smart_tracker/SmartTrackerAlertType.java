package smart_tracker;

public enum SmartTrackerAlertType {
    FEVER(1, "Febre"),
    TACHYCARDIA(2, "Taquicardia"),
    BRADYCARDIA(3, "Bradicardia");

    private final int value;
    private final String description;

    SmartTrackerAlertType(int value, String description) {
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
