package com.care.data_center.repository;

import com.care.data_center.entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepository {
    private final List<Patient> patients;

    public PatientRepository() {
        patients = new ArrayList<>();
    }

    public void save(Patient patient) {
        patients.add(patient);
    }

    public Optional<Patient> findByCPF(String cpf) {
        return patients.stream()
                .filter(patient -> patient.getCpf().equals(cpf)).findFirst();
    }

    public Optional<Patient> findById(Long id) {
        return patients.stream()
                .filter(patient -> patient.getPatientId().equals(id)).findFirst();
    }
}
