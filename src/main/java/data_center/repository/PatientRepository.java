package data_center.repository;

import data_center.entities.Patient;

import java.util.*;

public class PatientRepository {
    Map<Long, Patient> patients;

    public PatientRepository() {
        patients = new HashMap();
    }

    public PatientRepository(Map<Long, Patient> patients) {
        this.patients = patients;
    }

    public void register(Patient patient){
        patients.put(patient.getPatientId(), patient);
    }

    public Patient getPatient(Long patientId) {
        return patients.get(patientId);
    }

    public List<Patient> getPatients() {
        return new ArrayList<Patient>(patients.values());
    }
}
