package com.care.data_center.repository;

import com.care.data_center.entities.PatientLog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientLogRepository {
    private final List<PatientLog> patientLogs;

    public PatientLogRepository() {
        patientLogs = new ArrayList<>();
    }

    public void save(PatientLog patientLog) {
        patientLogs.add(patientLog);
    }

    public List<PatientLog> findAllByPatientId(Long patientId) {
        return patientLogs.stream().filter(log -> log.getPatientId().equals(patientId)).collect(Collectors.toList());
    }
}
