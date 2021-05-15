package data_center.controller;

import data_center.entities.Patient;

import java.util.List;

public interface PatientController {

    List<Patient> getAllPatients();
    Patient getPatient(Long patientId);
    boolean isPatientRegistered(Long patientId);
    boolean register(Patient patient);

}
