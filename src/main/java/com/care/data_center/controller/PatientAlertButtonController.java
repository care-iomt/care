package com.care.data_center.controller;

import com.care.data_center.entities.Patient;
import com.care.data_center.entities.PatientAlertButton;

import java.util.List;

public interface PatientAlertButtonController {
    /**
     * Salva um relacionamento entre AlertButton e Patient
     *
     * @param patient paciente
     * @param code    código do AlertButton
     */
    void save(Patient patient, Long code);

    /**
     * Remove relacionamento entre AlertButton e Patient
     *
     * @param patient paciente
     * @param code    código do AlertButton
     */
    void delete(Long code);

    /**
     * Busca um relacionamento pelo paciente
     *
     * @param patient paciente
     */
    PatientAlertButton getByPatient(Patient patient);

    /**
     * Busca um relacionamento pelo código do AlertButton
     *
     * @param code codigo
     */
    PatientAlertButton getByCode(Long code);

    /**
     * Busca todos os relacionamentos
     */
    List<PatientAlertButton> getAll();
}
