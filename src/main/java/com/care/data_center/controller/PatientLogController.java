package com.care.data_center.controller;

import com.care.data_center.entities.PatientLog;

import java.util.List;

public interface PatientLogController {
    /**
     * Salva um log de um monitor relacionado a um paciente
     *
     * @param patientId   id do paciente
     * @param monitorName nome do monitor causador do log
     * @param info        informações do log
     */
    void saveLog(Long patientId, String monitorName, String info);

    /**
     * Retorna todos os logs relacionados a um paciente
     *
     * @param patientId id do paciênte
     * @return lista de logs salvos no datacenter
     */
    List<PatientLog> getLogs(Long patientId);
}
