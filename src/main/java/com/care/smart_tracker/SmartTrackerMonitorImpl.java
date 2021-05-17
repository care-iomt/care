package com.care.smart_tracker;

import com.care.data_center.DataCenterConnection;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class SmartTrackerMonitorImpl implements SmartTrackerMonitor {
    private final List<SmartTrackerObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long code;
    private SmartTrackerDriver runnable;
    private boolean isRunning;
    private Long patientId;

    public SmartTrackerMonitorImpl(Long code) {
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.code = code;
        this.isRunning = false;
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(SmartTrackerObserver observer) {
        observerList.add(observer);
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public void start(Long patientId) {
        this.patientId = patientId;
        runnable = new SmartTrackerDriver(alertType -> {
            handleAlert(alertType);
            return null;
        });
        final Thread thread = new Thread(runnable);
        thread.start();
        isRunning = true;
    }

    @Override
    public void stop() {
        observerList.clear();
        runnable.kill();
        isRunning = false;
    }

    @Override
    public boolean isUsed() {
        return isRunning;
    }

    private void handleAlert(SmartTrackerAlertType alertType) {
        dataCenterConnection.getPatientLogController()
                .saveLog(patientId, "Smart Tracker", "Alert code: " + alertType.getValue());
        observerList.forEach(observer -> observer.alert(alertType, patientId));
    }
}
