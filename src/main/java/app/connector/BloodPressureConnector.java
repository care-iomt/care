package app.connector;

import app.observers.BloodPressureObserverImpl;
import blood_pressure.BloodPressureConfig;
import blood_pressure.BloodPressureMonitor;
import blood_pressure.BloodPressureMonitorImpl;
import data_center.entities.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BloodPressureConnector {
    private static BloodPressureConnector instance;
    private final List<BloodPressureMonitor> bloodPressureMonitors;

    private BloodPressureConnector() {
        bloodPressureMonitors = new ArrayList<>();

        final BloodPressureMonitor heartRateMonitor1 = new BloodPressureMonitorImpl(121212L);
        final BloodPressureMonitor heartRateMonitor2 = new BloodPressureMonitorImpl(321312L);
        final BloodPressureMonitor heartRateMonitor3 = new BloodPressureMonitorImpl(121214L);
        final BloodPressureMonitor heartRateMonitor4 = new BloodPressureMonitorImpl(323422L);
        final BloodPressureMonitor heartRateMonitor5 = new BloodPressureMonitorImpl(435434L);
        final BloodPressureMonitor heartRateMonitor6 = new BloodPressureMonitorImpl(321565L);
        final BloodPressureMonitor heartRateMonitor7 = new BloodPressureMonitorImpl(433556L);
        final BloodPressureMonitor heartRateMonitor8 = new BloodPressureMonitorImpl(958696L);

        bloodPressureMonitors.add(heartRateMonitor1);
        bloodPressureMonitors.add(heartRateMonitor2);
        bloodPressureMonitors.add(heartRateMonitor3);
        bloodPressureMonitors.add(heartRateMonitor4);
        bloodPressureMonitors.add(heartRateMonitor5);
        bloodPressureMonitors.add(heartRateMonitor6);
        bloodPressureMonitors.add(heartRateMonitor7);
        bloodPressureMonitors.add(heartRateMonitor8);
    }

    public static BloodPressureConnector getInstance() {
        if (instance == null){
            instance = new BloodPressureConnector();
        }
        return instance;
    }

    public List<BloodPressureMonitor> findAllUsed() {
        return bloodPressureMonitors.stream().filter(BloodPressureMonitor::isUsed).collect(Collectors.toList());
    }

    public List<BloodPressureMonitor> findAllNotUsed() {
        return bloodPressureMonitors.stream().filter(heartRateMonitor -> !heartRateMonitor.isUsed()).collect(Collectors.toList());
    }

    public Optional<BloodPressureMonitor> getByCode(Long code) {
        return bloodPressureMonitors.stream()
                .filter(heartRateMonitor -> code.equals(heartRateMonitor.getCode())).findFirst();
    }

    public Optional<BloodPressureMonitor> getByPatientId(Long patientId) {
        return bloodPressureMonitors.stream()
                .filter(heartRateMonitor -> patientId.equals(heartRateMonitor.getPatientId())).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, BloodPressureObserverImpl observer,
                                       BloodPressureConfig config) {
        getByCode(code).ifPresent(heartRateMonitor -> {
            heartRateMonitor.configure(config);
            heartRateMonitor.addObserver(observer);
            heartRateMonitor.start(patient.getPatientId());
        });
    }

    public void detachPatientOfMonitor(Long code) {
        final Optional<BloodPressureMonitor> bloodPressureMonitorOptional = getByCode(code);
        bloodPressureMonitorOptional.ifPresent(BloodPressureMonitor::stop);
    }
}
