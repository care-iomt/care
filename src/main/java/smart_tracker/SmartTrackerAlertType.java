package smart_tracker;

public enum SmartTrackerAlertType {
    FEVER(1),
    TACHYCARDIA(2),
    BRADYCARDIA(3);

    private int value;

    SmartTrackerAlertType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
