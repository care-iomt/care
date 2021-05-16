package app;

public enum SmartMonitors {
    HEART_RATE("Monitor Cardíaco"),
    SMART_TRACKER("Smart Tracker"),
    BLOOD_PRESSURE("Pressao Arterial"),
    TEMPERATURE_MONITOR("Monitor de Temperatura"),
    EMERGENCY_BUTTON("Botão de Emergência");

    private final String name;

    SmartMonitors(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
