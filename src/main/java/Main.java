import alert_button.AlertButtonMonitor;
import alert_button.AlertButtonMonitorImpl;
import alert_button.AlertButtonObserver;
import app.*;
import blood_pressure.BloodPressureMonitor;
import blood_pressure.BloodPressureMonitorImpl;
import blood_pressure.BloodPressureObserver;
import data_center.DataCenterConnection;
import heart_rate.HeartRateMonitor;
import heart_rate.HeartRateMonitorImpl;
import heart_rate.HeartRateObserver;
import smart_tracker.SmartTrackerMonitor;
import smart_tracker.SmartTrackerMonitorImpl;
import smart_tracker.SmartTrackerObserver;
import temperature_monitor.TemperatureMonitor;
import temperature_monitor.TemperatureMonitorImpl;
import temperature_monitor.TemperatureObserver;

public class Main {
    // TODO: Se sobrar tempo implementar:
    // Frequência Respiratória
    // Saturação de Oxigênio
    // Nível de Dióxido de Carbono
    public static void main(String[] args) throws InterruptedException {
        final DataCenterConnection dataCenterConnection = new DataCenterConnection();

        // ALERT BUTTON TEST
        final AlertButtonMonitor alertButtonMonitor = new AlertButtonMonitorImpl(1L, dataCenterConnection);
        final AlertButtonObserver alertButtonObserver = new AlertButtonObserverImpl();
        alertButtonMonitor.addObserver(alertButtonObserver);

        // BLOOD PRESSURE TEST
        final BloodPressureMonitor bloodPressureMonitor = new BloodPressureMonitorImpl(dataCenterConnection);
        bloodPressureMonitor.start(1L);
        final BloodPressureObserver bloodPressureObserver = new BloodPressureObserverImpl();
        bloodPressureMonitor.addObserver(bloodPressureObserver);

        // HEART RATE TEST
        final HeartRateMonitor heartRateMonitor = new HeartRateMonitorImpl(dataCenterConnection);
        heartRateMonitor.start(1L);
        final HeartRateObserver heartRateObserver = new HeartRateObserverImpl();
        heartRateMonitor.addObserver(heartRateObserver);

        // SMART TRACKER TEST
        final SmartTrackerMonitor smartTrackerMonitor = new SmartTrackerMonitorImpl(dataCenterConnection);
        smartTrackerMonitor.start(1L);
        final SmartTrackerObserver smartTrackerObserver = new SmartTrackerObserverImpl();
        smartTrackerMonitor.addObserver(smartTrackerObserver);

        // TEMPERATURE MONITOR
        final TemperatureMonitor temperatureMonitor = new TemperatureMonitorImpl(dataCenterConnection);
        temperatureMonitor.start(1L);
        final TemperatureObserver temperatureObserver = new TemperatureObserverImpl();
        temperatureMonitor.addObserver(temperatureObserver);

        while (true) {
            Thread.sleep(5000);
        }
    }


}
