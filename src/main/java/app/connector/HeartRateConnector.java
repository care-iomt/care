package app.connector;

import app.observers.HeartRateObserverImpl;
import data_center.DataCenterConnection;
import data_center.entities.Patient;
import heart_rate.HeartRateMonitor;
import heart_rate.HeartRateMonitorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HeartRateConnector {
    private static HeartRateConnector instance;
    private final List<HeartRateMonitor> heartRateMonitors;

    private HeartRateConnector() {
        final DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        heartRateMonitors = new ArrayList<>();
        final HeartRateMonitor heartRateMonitor1 = new HeartRateMonitorImpl(dataCenterConnection, 121212L);
        final HeartRateMonitor heartRateMonitor2 = new HeartRateMonitorImpl(dataCenterConnection, 321312L);
        final HeartRateMonitor heartRateMonitor3 = new HeartRateMonitorImpl(dataCenterConnection, 121214L);
        final HeartRateMonitor heartRateMonitor4 = new HeartRateMonitorImpl(dataCenterConnection, 323422L);
        final HeartRateMonitor heartRateMonitor5 = new HeartRateMonitorImpl(dataCenterConnection, 435434L);
        final HeartRateMonitor heartRateMonitor6 = new HeartRateMonitorImpl(dataCenterConnection, 321565L);
        final HeartRateMonitor heartRateMonitor7 = new HeartRateMonitorImpl(dataCenterConnection, 433556L);
        final HeartRateMonitor heartRateMonitor8 = new HeartRateMonitorImpl(dataCenterConnection, 958696L);

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
        if (instance == null){
            instance = new HeartRateConnector();
        }
        return instance;
    }

    public List<HeartRateMonitor> findAllUsed() {
        return heartRateMonitors.stream().filter(HeartRateMonitor::isUsed).collect(Collectors.toList());
    }

    public List<HeartRateMonitor> findAllNotUsed() {
        return heartRateMonitors.stream().filter(heartRateMonitor -> !heartRateMonitor.isUsed()).collect(Collectors.toList());
    }

    public Optional<HeartRateMonitor> getByCode(Long code) {
        return heartRateMonitors.stream()
                .filter(heartRateMonitor -> heartRateMonitor.getCode().equals(code)).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, HeartRateObserverImpl heartRateObserver) {
        getByCode(code).ifPresent(heartRateMonitor -> {
            heartRateMonitor.addObserver(heartRateObserver);
            heartRateMonitor.start(patient.getPatientId());
        });
    }
}
