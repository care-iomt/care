package com.care.data_center.controller;

import com.care.data_center.entities.Patient;
import com.care.data_center.entities.PatientAlertButton;
import com.care.data_center.repository.PatientAlertButtonRepository;

import java.util.List;

public class PatientAlertButtonControllerImpl implements PatientAlertButtonController {
    private final PatientAlertButtonRepository patientAlertButtonRepository;

    public PatientAlertButtonControllerImpl() {
        this.patientAlertButtonRepository = new PatientAlertButtonRepository();
    }


    @Override
    public void save(Patient patient, Long code) {
        patientAlertButtonRepository.save(patient, code);
    }

    @Override
    public void delete(Long code) {
        patientAlertButtonRepository.delete(code);
    }

    @Override
    public PatientAlertButton getByPatient(Patient patient) {
        return patientAlertButtonRepository.findByPatient(patient).orElse(null);
    }

    @Override
    public PatientAlertButton getByCode(Long code) {
        return patientAlertButtonRepository.findByCode(code).orElse(null);
    }

    @Override
    public List<PatientAlertButton> getAll() {
        return patientAlertButtonRepository.findAll();
    }
}
