package app.connector;

import app.observers.TemperatureObserverImpl;
import data_center.entities.Patient;
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
        temperatureMonitors = new ArrayList<>();
        final TemperatureMonitor heartRateMonitor1 = new TemperatureMonitorImpl(958696L);
        final TemperatureMonitor heartRateMonitor2 = new TemperatureMonitorImpl(321312L);
        final TemperatureMonitor heartRateMonitor3 = new TemperatureMonitorImpl(121214L);
        final TemperatureMonitor heartRateMonitor4 = new TemperatureMonitorImpl(323422L);
        final TemperatureMonitor heartRateMonitor5 = new TemperatureMonitorImpl(435434L);
        final TemperatureMonitor heartRateMonitor6 = new TemperatureMonitorImpl(321565L);
        final TemperatureMonitor heartRateMonitor7 = new TemperatureMonitorImpl(433556L);
        final TemperatureMonitor heartRateMonitor8 = new TemperatureMonitorImpl(121212L);

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
                .filter(temperatureMonitor -> code.equals(temperatureMonitor.getCode())).findFirst();
    }

    public Optional<TemperatureMonitor> getByPatientId(Long patientId) {
        return temperatureMonitors.stream()
                .filter(temperatureMonitor -> patientId.equals(temperatureMonitor.getPatientId())).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, TemperatureObserverImpl temperatureObserver,
                                       TemperatureConfig config) {
        getByCode(code).ifPresent(temperatureMonitor -> {
            temperatureMonitor.configure(config);
            temperatureMonitor.addObserver(temperatureObserver);
            temperatureMonitor.start(patient.getPatientId());
        });
    }

    public void detachPatientOfMonitor(Long code) {
        final Optional<TemperatureMonitor> temperatureMonitorOptional = getByCode(code);
        temperatureMonitorOptional.ifPresent(TemperatureMonitor::stop);
    }
}
