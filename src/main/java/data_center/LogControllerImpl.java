package data_center;

import java.util.List;

public class LogControllerImpl implements LogController {
    private final LogRepository logRepository;

    public LogControllerImpl() {
        logRepository = new LogRepository();
    }

    @Override
    public void saveLog(PatientLog patientLog) {
        logRepository.save(patientLog);
    }

    @Override
    public List<PatientLog> getLogs(Long patientId) {
        return logRepository.getAll(patientId);
    }
}
