package data_center.controller;

import data_center.entities.Patient;
import data_center.repository.PatientRepository;

import java.util.List;

public class PatientControllerImpl implements PatientController {
    private final PatientRepository patientRepository;

    public PatientControllerImpl() {
        patientRepository = new PatientRepository();
    }

    @Override
    public Patient getPatient(Long patientId) {
        return patientRepository.getPatient(patientId);
    }

    @Override
    public boolean isPatientRegistered(Long patientId) {
        return getPatient(patientId) != null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.getPatients();
    }

    @Override
    public boolean register(Patient patient) {
        patientRepository.register(patient);
        return true;
    }

}
