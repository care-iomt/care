package com.care.data_center.controller;

import com.care.data_center.entities.PatientLog;
import com.care.data_center.repository.PatientLogRepository;

import java.util.List;

public class PatientLogControllerImpl implements PatientLogController {
    private final PatientLogRepository patientLogRepository;

    public PatientLogControllerImpl() {
        patientLogRepository = new PatientLogRepository();
    }

    @Override
    public void saveLog(Long patientId, String monitorName, String info) {
        final PatientLog patientLog = new PatientLog();
        patientLog.setPatientId(patientId);
        patientLog.setMonitorName(monitorName);
        patientLog.setInfo(info);
        patientLogRepository.save(patientLog);
    }

    @Override
    public List<PatientLog> getLogs(Long patientId) {
        return patientLogRepository.findAllByPatientId(patientId);
    }
}
