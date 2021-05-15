package app;

import app.ui.MainUI;

import javax.swing.*;

public enum SmartMonitors {
    HEART_RATE("Monitor Cardíaco", MainUI.getInstance()),
    SMART_TRACKER("Smart Tracker", MainUI.getInstance()),
    BLOOD_PRESSURE("Pressao Arterial", MainUI.getInstance()),
    TEMPERATURE_MONITOR("Monitor de Temperatura", MainUI.getInstance());

    private final String name;
    private final JFrame guiClass;

    SmartMonitors(String name, JFrame guiClass) {
        this.name = name;
        this.guiClass = guiClass;
    }

    public String getName() {
        return name;
    }

    public JFrame getGuiClass() {
        return guiClass;
    }
}
