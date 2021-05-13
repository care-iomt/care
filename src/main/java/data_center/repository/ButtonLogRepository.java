package data_center.repository;

import data_center.entities.ButtonLog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ButtonLogRepository {
    private final List<ButtonLog> buttonLogs;

    public ButtonLogRepository() {
        buttonLogs = new ArrayList<>();
    }

    public void save(ButtonLog buttonLog) {
        buttonLogs.add(buttonLog);
    }

    public List<ButtonLog> getAll(Long id) {
        return buttonLogs.stream().filter(log -> log.getId().equals(id)).collect(Collectors.toList());
    }
}
