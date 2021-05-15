package app.connector;

import app.observers.TemperatureObserverImpl;
import data_center.DataCenterConnection;
import data_center.entities.Patient;
import smart_tracker.SmartTrackerMonitor;
import temperature_monitor.TemperatureConfig;
import temperature_monitor.TemperatureMonitor;
import temperature_monitor.TemperatureMonitorImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TemperatureConnector {
    private static TemperatureConnector instance;
    private final List<TemperatureMonitor> temperatureMonitors;

    private TemperatureConnector() {
        final DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        temperatureMonitors = new ArrayList<>();
        final TemperatureMonitor heartRateMonitor1 = new TemperatureMonitorImpl(dataCenterConnection, 121212L);
        final TemperatureMonitor heartRateMonitor2 = new TemperatureMonitorImpl(dataCenterConnection, 321312L);
        final TemperatureMonitor heartRateMonitor3 = new TemperatureMonitorImpl(dataCenterConnection, 121214L);
        final TemperatureMonitor heartRateMonitor4 = new TemperatureMonitorImpl(dataCenterConnection, 323422L);
        final TemperatureMonitor heartRateMonitor5 = new TemperatureMonitorImpl(dataCenterConnection, 435434L);
        final TemperatureMonitor heartRateMonitor6 = new TemperatureMonitorImpl(dataCenterConnection, 321565L);
        final TemperatureMonitor heartRateMonitor7 = new TemperatureMonitorImpl(dataCenterConnection, 433556L);
        final TemperatureMonitor heartRateMonitor8 = new TemperatureMonitorImpl(dataCenterConnection, 958696L);

        temperatureMonitors.add(heartRateMonitor1);
        temperatureMonitors.add(heartRateMonitor2);
        temperatureMonitors.add(heartRateMonitor3);
        temperatureMonitors.add(heartRateMonitor4);
        temperatureMonitors.add(heartRateMonitor5);
        temperatureMonitors.add(heartRateMonitor6);
        temperatureMonitors.add(heartRateMonitor7);
        temperatureMonitors.add(heartRateMonitor8);
    }

    public static TemperatureConnector getInstance() {
        if (instance == null){
            instance = new TemperatureConnector();
        }
        return instance;
    }

    public List<TemperatureMonitor> findAllUsed() {
        return temperatureMonitors.stream().filter(TemperatureMonitor::isUsed).collect(Collectors.toList());
    }

    public List<TemperatureMonitor> findAllNotUsed() {
        return temperatureMonitors.stream().filter(temperatureMonitor -> !temperatureMonitor.isUsed()).collect(Collectors.toList());
    }

    public Optional<TemperatureMonitor> getByCode(Long code) {
        return temperatureMonitors.stream()
                .filter(heartRateMonitor -> heartRateMonitor.getCode().equals(code)).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, TemperatureObserverImpl temperatureObserver,
                                       TemperatureConfig config) {
        getByCode(code).ifPresent(temperatureMonitor -> {
            temperatureMonitor.configure(config);
            temperatureMonitor.addObserver(temperatureObserver);
            temperatureMonitor.start(patient.getPatientId());
        });
    }
}
