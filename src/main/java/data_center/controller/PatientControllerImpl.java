package data_center.controller;

import data_center.entities.Patient;
import data_center.repository.PatientRepository;

import java.util.Optional;

public class PatientControllerImpl implements PatientController {
    private final PatientRepository patientRepository;

    public PatientControllerImpl() {
        patientRepository = new PatientRepository();
    }

    @Override
    public Patient getByCPF(String cpf) {
        Optional<Patient> patientSearch = patientRepository.findByCPF(cpf);
        return patientSearch.orElse(null);
    }

    @Override
    public boolean isRegistered(String cpf) {
        return patientRepository.findByCPF(cpf).isPresent();
    }

    @Override
    public boolean register(Patient patient) {
        patientRepository.save(patient);
        return true;
    }

}
