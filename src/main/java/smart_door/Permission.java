package smart_door;

public enum Permission {
    ADMIN(1),
    MEDICAL(2),
    NURSE(3),
    STAFF(4),
    PATIENT(5),
    VISITOR(6);

    private final int value;

    Permission(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
