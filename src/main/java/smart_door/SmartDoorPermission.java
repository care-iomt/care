package smart_door;

public enum SmartDoorPermission {
    ADMIN(1),
    MEDICAL(2),
    NURSE(3),
    STAFF(4),
    PATIENT(5),
    VISITOR(6);

    private final int value;

    SmartDoorPermission(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
