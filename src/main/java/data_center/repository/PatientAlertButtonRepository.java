package data_center.repository;

import data_center.entities.Patient;
import data_center.entities.PatientAlertButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientAlertButtonRepository {
    private List<PatientAlertButton> patientAlertButtons;

    public PatientAlertButtonRepository() {
        patientAlertButtons = new ArrayList<>();
    }

    public void save(Patient patient, Long code) {
        final Optional<PatientAlertButton> patientAlertButtonSearch = patientAlertButtons
                .stream().filter(patientAlertButton -> patientAlertButton.getAlertButtonCode().equals(code)).findFirst();
        if (patientAlertButtonSearch.isPresent()) {
            patientAlertButtonSearch.get().setPatient(patient);
        } else {
            final PatientAlertButton patientAlertButton = new PatientAlertButton();
            patientAlertButton.setAlertButtonCode(code);
            patientAlertButton.setPatient(patient);
            patientAlertButtons.add(patientAlertButton);
        }
    }

    public Optional<PatientAlertButton> findByPatient(Patient patient) {
        return patientAlertButtons.stream()
                .filter(patientAlertButton -> patientAlertButton.getPatient().getPatientId().equals(patient.getPatientId()))
                .findFirst();
    }

    public Optional<PatientAlertButton> findByCode(Long code) {
        return patientAlertButtons.stream()
                .filter(patientAlertButton -> patientAlertButton.getAlertButtonCode().equals(code))
                .findFirst();
    }

    public List<PatientAlertButton> findAll() {
        return this.patientAlertButtons;
    }
}
