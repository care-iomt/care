package temperature_monitor;

public enum AlertType {
    MAX(1),
    MIN(2);

    private final int value;

    AlertType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
