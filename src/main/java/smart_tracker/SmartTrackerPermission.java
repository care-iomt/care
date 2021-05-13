package smart_tracker;

public enum SmartTrackerPermission {
    ADMIN(1),
    MEDICAL(2),
    NURSE(3),
    STAFF(4),
    PATIENT(5),
    VISITOR(6),
    NONE(7);

    private final int value;

    SmartTrackerPermission(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}