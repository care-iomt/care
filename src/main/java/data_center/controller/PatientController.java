package data_center.controller;

import data_center.entities.Patient;

public interface PatientController {
    Patient getByCPF(String cpf);
    Patient getById(Long patientId);
    boolean isRegistered(String cpf);
    boolean register(Patient patient);
}
