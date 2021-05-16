package data_center.controller;

import data_center.entities.Patient;
import data_center.repository.PatientRepository;
import data_center.utils.StringUtils;
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
    public Patient getById(Long patientId) {
        Optional<Patient> patientSearch = patientRepository.findById(patientId);
        return patientSearch.orElse(null);
    }

    @Override
    public boolean isRegistered(String cpf) {
        return patientRepository.findByCPF(cpf).isPresent();
    }

    @Override
    public boolean register(Patient patient) {
        if (StringUtils.isValidCpf(patient.getCpf())) {
            patientRepository.save(patient);
            return true;
        } else {
            return false;
        }
    }
}
