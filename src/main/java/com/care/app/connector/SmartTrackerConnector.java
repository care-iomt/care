package com.care.app.connector;

import com.care.app.observers.SmartTrackerObserverImpl;
import com.care.data_center.entities.Patient;
import com.care.smart_tracker.SmartTrackerMonitor;
import com.care.smart_tracker.SmartTrackerMonitorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SmartTrackerConnector {
    private static SmartTrackerConnector instance;
    private final List<SmartTrackerMonitor> smartTrackerMonitors;

    private SmartTrackerConnector() {
        smartTrackerMonitors = new ArrayList<>();

        final SmartTrackerMonitor smartTrackerConnector1 = new SmartTrackerMonitorImpl(45245454L);
        final SmartTrackerMonitor smartTrackerConnector2 = new SmartTrackerMonitorImpl(45454454L);
        final SmartTrackerMonitor smartTrackerConnector3 = new SmartTrackerMonitorImpl(87578575L);
        final SmartTrackerMonitor smartTrackerConnector4 = new SmartTrackerMonitorImpl(54457772L);
        final SmartTrackerMonitor smartTrackerConnector5 = new SmartTrackerMonitorImpl(24524524L);
        final SmartTrackerMonitor smartTrackerConnector6 = new SmartTrackerMonitorImpl(45244257L);
        final SmartTrackerMonitor smartTrackerConnector7 = new SmartTrackerMonitorImpl(78758725L);
        final SmartTrackerMonitor smartTrackerConnector8 = new SmartTrackerMonitorImpl(45254244L);

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
        if (instance == null) {
            instance = new SmartTrackerConnector();
        }
        return instance;
    }

    public List<SmartTrackerMonitor> findAllNotUsed() {
        return smartTrackerMonitors.stream().filter(smartTrackerMonitor -> !smartTrackerMonitor.isUsed()).collect(Collectors.toList());
    }

    public Optional<SmartTrackerMonitor> getByCode(Long code) {
        return smartTrackerMonitors.stream()
                .filter(smartTrackerMonitor -> code.equals(smartTrackerMonitor.getCode())).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, SmartTrackerObserverImpl observer) {
        getByCode(code).ifPresent(smartTrackerMonitor -> {
            smartTrackerMonitor.addObserver(observer);
            smartTrackerMonitor.start(patient.getPatientId());
        });
    }

    public void detachPatientOfMonitor(Long code) {
        final Optional<SmartTrackerMonitor> smartTrackerMonitorOptional = getByCode(code);
        smartTrackerMonitorOptional.ifPresent(SmartTrackerMonitor::stop);
    }
}
