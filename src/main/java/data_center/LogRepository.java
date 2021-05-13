package data_center;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogRepository {
    private final List<PatientLog> patientLogs;

    public LogRepository() {
        patientLogs = new ArrayList<>();
    }

    public void save(PatientLog patientLog) {
        patientLogs.add(patientLog);
    }

    public List<PatientLog> getAll(Long patientId) {
        return patientLogs.stream().filter(log -> log.getPatientId().equals(patientId)).collect(Collectors.toList());
    }
}
