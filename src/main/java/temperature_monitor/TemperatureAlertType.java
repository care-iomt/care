package temperature_monitor;

public enum TemperatureAlertType {
    MAX(1, "Temperatura Máxima"),
    MIN(2, "Temperatura Mínima");

    private final int value;
    private final String description;

    TemperatureAlertType(int value, String description) {
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
