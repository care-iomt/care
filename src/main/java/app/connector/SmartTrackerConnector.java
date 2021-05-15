package app.connector;

import app.observers.SmartTrackerObserverImpl;
import data_center.DataCenterConnection;
import data_center.entities.Patient;
import smart_tracker.SmartTrackerConfig;
import smart_tracker.SmartTrackerMonitor;
import smart_tracker.SmartTrackerMonitorImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SmartTrackerConnector {
    private static SmartTrackerConnector instance;
    private final List<SmartTrackerMonitor> smartTrackerMonitors;

    private SmartTrackerConnector() {
        final DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        smartTrackerMonitors = new ArrayList<>();

        final SmartTrackerMonitor smartTrackerConnector1 = new SmartTrackerMonitorImpl(dataCenterConnection, 121212L);
        final SmartTrackerMonitor smartTrackerConnector2 = new SmartTrackerMonitorImpl(dataCenterConnection, 321312L);
        final SmartTrackerMonitor smartTrackerConnector3 = new SmartTrackerMonitorImpl(dataCenterConnection, 121214L);
        final SmartTrackerMonitor smartTrackerConnector4 = new SmartTrackerMonitorImpl(dataCenterConnection, 323422L);
        final SmartTrackerMonitor smartTrackerConnector5 = new SmartTrackerMonitorImpl(dataCenterConnection, 435434L);
        final SmartTrackerMonitor smartTrackerConnector6 = new SmartTrackerMonitorImpl(dataCenterConnection, 321565L);
        final SmartTrackerMonitor smartTrackerConnector7 = new SmartTrackerMonitorImpl(dataCenterConnection, 433556L);
        final SmartTrackerMonitor smartTrackerConnector8 = new SmartTrackerMonitorImpl(dataCenterConnection, 958696L);

        smartTrackerMonitors.add(smartTrackerConnector1);
        smartTrackerMonitors.add(smartTrackerConnector2);
        smartTrackerMonitors.add(smartTrackerConnector3);
        smartTrackerMonitors.add(smartTrackerConnector4);
        smartTrackerMonitors.add(smartTrackerConnector5);
        smartTrackerMonitors.add(smartTrackerConnector6);
        smartTrackerMonitors.add(smartTrackerConnector7);
        smartTrackerMonitors.add(smartTrackerConnector8);
    }

    public static SmartTrackerConnector getInstance() {
        if (instance == null){
            instance = new SmartTrackerConnector();
        }
        return instance;
    }

    public List<SmartTrackerMonitor> findAllUsed() {
        return smartTrackerMonitors.stream().filter(SmartTrackerMonitor::isUsed).collect(Collectors.toList());
    }

    public List<SmartTrackerMonitor> findAllNotUsed() {
        return smartTrackerMonitors.stream().filter(smartTrackerMonitor -> !smartTrackerMonitor.isUsed()).collect(Collectors.toList());
    }

    public Optional<SmartTrackerMonitor> getByCode(Long code) {
        return smartTrackerMonitors.stream()
                .filter(smartTrackerMonitor -> smartTrackerMonitor.getCode().equals(code)).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, SmartTrackerObserverImpl observer,
                                       SmartTrackerConfig config) {
        getByCode(code).ifPresent(smartTrackerMonitor -> {
            smartTrackerMonitor.addObserver(observer);
            smartTrackerMonitor.configure(config);
            smartTrackerMonitor.start(patient.getPatientId());
        });
    }
}
