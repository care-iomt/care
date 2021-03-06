package com.care.app.connector;

import com.care.alert_button.AlertButtonMonitor;
import com.care.alert_button.AlertButtonMonitorImpl;
import com.care.app.observers.AlertButtonObserverImpl;
import com.care.data_center.DataCenterConnection;
import com.care.data_center.controller.PatientAlertButtonController;
import com.care.data_center.entities.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlertButtonConnector {
    private static AlertButtonConnector instance;
    private final List<AlertButtonMonitor> alertButtonMonitors;
    private final DataCenterConnection dataCenterConnection;

    private AlertButtonConnector() {
        dataCenterConnection = DataCenterConnection.getInstance();
        alertButtonMonitors = new ArrayList<>();

        final AlertButtonMonitor alertButtonMonitor1 = new AlertButtonMonitorImpl(321312L);
        final AlertButtonMonitor alertButtonMonitor2 = new AlertButtonMonitorImpl(121212L);
        final AlertButtonMonitor alertButtonMonitor3 = new AlertButtonMonitorImpl(121214L);
        final AlertButtonMonitor alertButtonMonitor4 = new AlertButtonMonitorImpl(323422L);
        final AlertButtonMonitor alertButtonMonitor5 = new AlertButtonMonitorImpl(435434L);
        final AlertButtonMonitor alertButtonMonitor6 = new AlertButtonMonitorImpl(321565L);
        final AlertButtonMonitor alertButtonMonitor7 = new AlertButtonMonitorImpl(433556L);
        final AlertButtonMonitor alertButtonMonitor8 = new AlertButtonMonitorImpl(958696L);

        alertButtonMonitors.add(alertButtonMonitor1);
        alertButtonMonitors.add(alertButtonMonitor2);
        alertButtonMonitors.add(alertButtonMonitor3);
        alertButtonMonitors.add(alertButtonMonitor4);
        alertButtonMonitors.add(alertButtonMonitor5);
        alertButtonMonitors.add(alertButtonMonitor6);
        alertButtonMonitors.add(alertButtonMonitor7);
        alertButtonMonitors.add(alertButtonMonitor8);
    }

    public static AlertButtonConnector getInstance() {
        if (instance == null) {
            instance = new AlertButtonConnector();
        }
        return instance;
    }

    public List<AlertButtonMonitor> findAll() {
        return alertButtonMonitors;
    }

    public Optional<AlertButtonMonitor> findByCode(Long code) {
        return alertButtonMonitors.stream()
                .filter(alertButtonMonitor -> alertButtonMonitor.getCode().equals(code)).findFirst();
    }

    public void attachPatientToMonitor(Patient patient, Long code, AlertButtonObserverImpl alertButtonObserver) {
        final Optional<AlertButtonMonitor> alertButtonMonitorSearch = findByCode(code);
        if (alertButtonMonitorSearch.isPresent()) {
            final AlertButtonMonitor alertButtonMonitor = alertButtonMonitorSearch.get();
            final PatientAlertButtonController controller = dataCenterConnection.getPatientAlertButtonController();
            controller.save(patient, code);
            alertButtonMonitor.addObserver(alertButtonObserver);
        }
    }

    public void detachPatientOfMonitor(Long code, AlertButtonObserverImpl alertButtonObserver) {
        final Optional<AlertButtonMonitor> alertButtonMonitorOptional = findByCode(code);
        alertButtonMonitorOptional.ifPresent(alertButtonMonitor -> {
            final PatientAlertButtonController controller = dataCenterConnection.getPatientAlertButtonController();
            controller.delete(code);
            alertButtonMonitor.removeObserver(alertButtonObserver);
        });
    }
}
