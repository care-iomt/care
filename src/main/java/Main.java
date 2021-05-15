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
        final DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();

        /*
        // ALERT BUTTON TEST
        final AlertButtonMonitor alertButtonMonitor = new AlertButtonMonitorImpl(0L, dataCenterConnection);
        final AlertButtonObserver alertButtonObserver = new AlertButtonObserverImpl();
        alertButtonMonitor.addObserver(alertButtonObserver);

        // BLOOD PRESSURE TEST
        final BloodPressureMonitor bloodPressureMonitor = new BloodPressureMonitorImpl(dataCenterConnection);
        bloodPressureMonitor.start(0L);
        final BloodPressureObserver bloodPressureObserver = new BloodPressureObserverImpl();
        bloodPressureMonitor.addObserver(bloodPressureObserver);

        // HEART RATE TEST
        final HeartRateMonitor heartRateMonitor = new HeartRateMonitorImpl(dataCenterConnection);
        heartRateMonitor.start(0L);
        final HeartRateObserver heartRateObserver = new HeartRateObserverImpl();
        heartRateMonitor.addObserver(heartRateObserver);

        // SMART TRACKER TEST
        final SmartTrackerMonitor smartTrackerMonitor = new SmartTrackerMonitorImpl(dataCenterConnection);
        smartTrackerMonitor.start(0L);
        final SmartTrackerObserver smartTrackerObserver = new SmartTrackerObserverImpl();
        smartTrackerMonitor.addObserver(smartTrackerObserver);

        // TEMPERATURE MONITOR
        final TemperatureMonitor temperatureMonitor = new TemperatureMonitorImpl(dataCenterConnection);
        temperatureMonitor.start(0L);
        final TemperatureObserver temperatureObserver = new TemperatureObserverImpl();
        temperatureMonitor.addObserver(temperatureObserver);


        PatientController patientAPI = DataCenterConnection.getInstance().getPatientController();
        Patient patient1 = new Patient("Fulano de Tal", "000.000.000-00");
        patientAPI.register(patient1);
        Patient patient2 = new Patient("Ciclado de Tal", "000.000.000-01");
        patientAPI.register(patient2);
        Patient patient3 = new Patient("Fulano Beltrano", "000.000.000-02");
        patientAPI.register(patient3);
        Patient patient4 = new Patient("Ciclano Beltrano", "000.000.000-03");
        patientAPI.register(patient4);
*/
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
