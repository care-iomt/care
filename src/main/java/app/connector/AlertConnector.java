package app.connector;

import alert_button.AlertButtonMonitor;
import alert_button.AlertButtonMonitorImpl;
import alert_button.AlertButtonObserver;
import data_center.DataCenterConnection;
import data_center.controller.PatientAlertButtonController;
import data_center.entities.Patient;
import data_center.entities.PatientAlertButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlertConnector {
    private static AlertConnector instance;
    private final List<AlertButtonMonitor> alertButtonMonitors;
    private final DataCenterConnection dataCenterConnection;

    private AlertConnector() {
        dataCenterConnection = DataCenterConnection.getInstance();
        alertButtonMonitors = new ArrayList<>();

        final AlertButtonMonitor alertButtonMonitor1 = new AlertButtonMonitorImpl(121212L);
        final AlertButtonMonitor alertButtonMonitor2 = new AlertButtonMonitorImpl(321312L);
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

    public static AlertConnector getInstance() {
        if (instance == null){
            instance = new AlertConnector();
        }
        return instance;
    }

    public List<AlertButtonMonitor> findAllNotUsed() {
        final PatientAlertButtonController controller = dataCenterConnection.getPatientAlertButtonController();
        final List<PatientAlertButton> patientAlertButtons = controller.getAll();

        return alertButtonMonitors.stream()
                .filter(alertButtonMonitor ->
                        patientAlertButtons.stream()
                                .noneMatch(patientAlertButton ->
                                        patientAlertButton.getAlertButtonCode().equals(alertButtonMonitor.getCode())))
                .collect(Collectors.toList());
    }

    public List<AlertButtonMonitor> findAllUsed() {
        final PatientAlertButtonController controller = dataCenterConnection.getPatientAlertButtonController();
        final List<PatientAlertButton> patientAlertButtons = controller.getAll();

        return alertButtonMonitors.stream()
                .filter(alertButtonMonitor ->
                        patientAlertButtons.stream()
                                .anyMatch(patientAlertButton ->
                                        patientAlertButton.getAlertButtonCode().equals(alertButtonMonitor.getCode())))
                .collect(Collectors.toList());
    }

    public Optional<AlertButtonMonitor> getByCode(Long code) {
        return alertButtonMonitors.stream()
                .filter(alertButtonMonitor -> alertButtonMonitor.getCode().equals(code)).findFirst();
    }

    public Optional<AlertButtonMonitor> getByPatient(Patient patient) {
        final PatientAlertButtonController controller = dataCenterConnection.getPatientAlertButtonController();
        final PatientAlertButton patientAlertButton = controller.getByPatient(patient);
        if (patientAlertButton != null) {
            final Long code = patientAlertButton.getAlertButtonCode();
            return alertButtonMonitors.stream()
                    .filter(alertButtonMonitor -> alertButtonMonitor.getCode().equals(code)).findFirst();
        }
        return Optional.empty();
    }

    public Optional<Patient> getPatient(Long code) {
        final PatientAlertButtonController controller = dataCenterConnection.getPatientAlertButtonController();
        final PatientAlertButton patientAlertButton = controller.getByCode(code);
        if (patientAlertButton != null) {
            return Optional.of(patientAlertButton.getPatient());
        }
        return Optional.empty();
    }

    public void attachPatientToMonitor(Patient patient, Long code, AlertButtonObserver alertButtonObserver) {
        final Optional<AlertButtonMonitor> alertButtonMonitorSearch = getByCode(code);
        if (alertButtonMonitorSearch.isPresent()) {
            final AlertButtonMonitor alertButtonMonitor = alertButtonMonitorSearch.get();
            final PatientAlertButtonController controller = dataCenterConnection.getPatientAlertButtonController();
            controller.save(patient, code);
            alertButtonMonitor.addObserver(alertButtonObserver);
        }
    }
}
