package data_center.repository;

import data_center.entities.Patient;
import java.util.*;

public class PatientRepository {
    private final List<Patient> patients;

    public PatientRepository() {
        patients = new ArrayList<>();
    }

    public void save(Patient patient){
        patients.add(patient);
    }

    public Optional<Patient> findByCPF(String cpf) {
        return patients.stream()
                .filter(patient -> patient.getCpf().equals(cpf)).findFirst();
    }
}
