package com.care.app.connector;

import com.care.app.observers.HeartRateObserverImpl;
import com.care.data_center.entities.Patient;
import com.care.heart_rate.HeartRateConfig;
import com.care.heart_rate.HeartRateMonitor;
import com.care.heart_rate.HeartRateMonitorImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HeartRateConnector {
    private static HeartRateConnector instance;
    private final List<HeartRateMonitor> heartRateMonitors;

    private HeartRateConnector() {
        heartRateMonitors = new ArrayList<>();
        final HeartRateMonitor heartRateMonitor1 = new HeartRateMonitorImpl(435434L);
        final HeartRateMonitor heartRateMonitor2 = new HeartRateMonitorImpl(321312L);
        final HeartRateMonitor heartRateMonitor3 = new HeartRateMonitorImpl(121214L);
        final HeartRateMonitor heartRateMonitor4 = new HeartRateMonitorImpl(323422L);
        final HeartRateMonitor heartRateMonitor5 = new HeartRateMonitorImpl(121212L);
        final HeartRateMonitor heartRateMonitor6 = new HeartRateMonitorImpl(321565L);
        final HeartRateMonitor heartRateMonitor7 = new HeartRateMonitorImpl(433556L);
        final HeartRateMonitor heartRateMonitor8 = new HeartRateMonitorImpl(958696L);

        heartRateMonitors.add(heartRateMonitor1);
        heartRateMonitors.add(heartRateMonitor2);
        heartRateMonitors.add(heartRateMonitor3);
        heartRateMonitors.add(heartRateMonitor4);
        heartRateMonitors.add(heartRateMonitor5);
        heartRateMonitors.add(heartRateMonitor6);
        heartRateMonitors.add(heartRateMonitor7);
        heartRateMonitors.add(heartRateMonitor8);
    }

    public static HeartRateConnector getInstance() {
        if (instance == null) {
            instance = new HeartRateConnector();
        }
        return instance;
    }

    public List<HeartRateMonitor> findAllNotUsed() {
        return heartRateMonitors.stream().filter(heartRateMonitor -> !heartRateMonitor.isUsed()).collect(Collectors.toList());
    }

    public Optional<HeartRateMonitor> getByCode(Long code) {
        return heartRateMonitors.stream()
                .filter(heartRateMonitor -> code.equals(heartRateMonitor.getCode())).findFirst();
    }

    public Optional<HeartRateMonitor> getByPatientId(Long patientId) {
        return heartRateMonitors.stream()
                .filter(heartRateMonitor -> patientId.equals(heartRateMonitor.getPatientId())).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, HeartRateObserverImpl heartRateObserver,
                                       HeartRateConfig config) {
        getByCode(code).ifPresent(heartRateMonitor -> {
            heartRateMonitor.configure(config);
            heartRateMonitor.addObserver(heartRateObserver);
            heartRateMonitor.start(patient.getPatientId());
        });
    }

    public void detachPatientOfMonitor(Long code) {
        final Optional<HeartRateMonitor> heartRateMonitorOptional = getByCode(code);
        heartRateMonitorOptional.ifPresent(HeartRateMonitor::stop);
    }
}
