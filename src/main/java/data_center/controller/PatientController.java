package data_center.controller;

import data_center.entities.Patient;

public interface PatientController {
    Patient getByCPF(String cpf);
    boolean isRegistered(String cpf);
    boolean register(Patient patient);
}
