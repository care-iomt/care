package app;

public enum SmartMonitors {
    HEART_RATE("Monitor Cardíaco"),
    SMART_TRACKER("Smart Tracker"),
    BLOOD_PRESSURE("Pressao Arterial"),
    TEMPERATURE_MONITOR("Monitor de Temperatura");

    private final String name;
//    private final JFrame guiClass;

    SmartMonitors(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public JFrame getGuiClass() {
//        return guiClass;
//    }
}
