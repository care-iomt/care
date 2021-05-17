package com.care.heart_rate;

import com.care.data_center.DataCenterConnection;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class HeartRateMonitorImpl implements HeartRateMonitor {
    private final List<HeartRateObserver> observerList;
    private final HeartRateState state;
    private final Long code;
    private final DataCenterConnection dataCenterConnection;
    private Long patientId;
    private HeartRateConfig config;
    private HeartRateDriver runnable;
    private boolean isRunning;

    public HeartRateMonitorImpl(Long code) {
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.code = code;
        this.isRunning = false;

        observerList = new ArrayList<>();

        state = new HeartRateState();
        state.setHeartRate(0);

        config = new HeartRateConfig();

        final HeartRateState minState = new HeartRateState();
        minState.setHeartRate(Integer.MIN_VALUE);
        config.setMinState(minState);

        final HeartRateState maxState = new HeartRateState();
        maxState.setHeartRate(Integer.MAX_VALUE);
        config.setMinState(maxState);
    }

    @Override
    public void start(Long patientId) {
        this.patientId = patientId;
        runnable = new HeartRateDriver(heartRate -> {
            handleHeartRateRead(heartRate);
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
    public HeartRateState getCurrentState() {
        return state;
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public boolean isUsed() {
        return isRunning;
    }

    @Override
    public Long getPatientId() {
        return this.patientId;
    }

    @Override
    public void addObserver(HeartRateObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void configure(HeartRateConfig config) {
        this.config = config;
    }

    private void handleHeartRateRead(int heartRate) {
        final HeartRateAlertType alertType = checkShouldAlert(heartRate);
        if (alertType != null) {
            saveLog("Alerta: " + alertType.getValue());
            observerList.forEach(observer -> observer.alert(alertType, patientId));
        }
    }

    private HeartRateAlertType checkShouldAlert(int heartRate) {
        state.setHeartRate(heartRate);
        saveLog("Batimentos: " + heartRate);
        if (heartRate > config.getMaxState().getHeartRate()) {
            return HeartRateAlertType.MAX;
        } else if (heartRate < config.getMinState().getHeartRate()) {
            return HeartRateAlertType.MIN;
        } else {
            return null;
        }
    }

    private void saveLog(String info) {
        dataCenterConnection.getPatientLogController().saveLog(patientId, "Monitor de Batimentos", info);
    }
}
