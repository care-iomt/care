package com.care.data_center.repository;

import com.care.data_center.entities.Patient;
import com.care.data_center.entities.PatientAlertButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientAlertButtonRepository {
    private List<PatientAlertButton> patientAlertButtons;

    public PatientAlertButtonRepository() {
        patientAlertButtons = new ArrayList<>();
    }

    public void save(Patient patient, Long code) {
        final Optional<PatientAlertButton> patientAlertButtonSearch = findByCode(code);
        if (patientAlertButtonSearch.isPresent()) {
            patientAlertButtonSearch.get().setPatient(patient);
        } else {
            final PatientAlertButton patientAlertButton = new PatientAlertButton();
            patientAlertButton.setAlertButtonCode(code);
            patientAlertButton.setPatient(patient);
            patientAlertButtons.add(patientAlertButton);
        }
    }

    public void delete(Long code) {
        final Optional<PatientAlertButton> patientAlertButtonSearch = findByCode(code);
        patientAlertButtonSearch.ifPresent(patientAlertButton -> {
            patientAlertButtons.remove(patientAlertButton);
        });
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
