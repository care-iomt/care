import alert_button.AlertButtonMonitor;
import alert_button.AlertButtonMonitorImpl;
import alert_button.AlertButtonObserver;
import app.observers.*;
import app.ui.MainUI;
import blood_pressure.BloodPressureMonitor;
import blood_pressure.BloodPressureMonitorImpl;
import blood_pressure.BloodPressureObserver;
import data_center.DataCenterConnection;
import data_center.controller.PatientController;
import data_center.entities.Patient;
import heart_rate.HeartRateMonitor;
import heart_rate.HeartRateMonitorImpl;
import heart_rate.HeartRateObserver;
import smart_tracker.SmartTrackerMonitor;
import smart_tracker.SmartTrackerMonitorImpl;
import smart_tracker.SmartTrackerObserver;
import temperature_monitor.TemperatureMonitor;
import temperature_monitor.TemperatureMonitorImpl;
import temperature_monitor.TemperatureObserver;

import javax.swing.*;

public class Main {
    // TODO: Se sobrar tempo implementar:
    // Frequência Respiratória
    // Saturação de Oxigênio
    // Nível de Dióxido de Carbono
    public static void main(String[] args) throws InterruptedException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            MainUI mainUI = new MainUI();
            mainUI.setVisible(true);
        });
    }
}
