package data_center.controller;

import data_center.entities.ButtonLog;
import data_center.repository.ButtonLogRepository;

import java.util.List;

public class ButtonLogControllerImpl implements ButtonLogController {
    private final ButtonLogRepository repository;

    public ButtonLogControllerImpl() {
        repository = new ButtonLogRepository();
    }

    @Override
    public void saveLog(Long id, String info) {
        final ButtonLog buttonLog = new ButtonLog();
        buttonLog.setId(id);
        buttonLog.setInfo(info);
        repository.save(buttonLog);
    }

    @Override
    public List<ButtonLog> getLogs(Long patientId) {
        return repository.getAll(patientId);
    }
}
