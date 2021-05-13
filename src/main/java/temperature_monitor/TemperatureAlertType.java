package temperature_monitor;

public enum TemperatureAlertType {
    MAX(1),
    MIN(2);

    private final int value;

    TemperatureAlertType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
