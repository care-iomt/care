package com.care.temperature_monitor;

import com.care.data_center.DataCenterConnection;

import java.util.ArrayList;
import java.util.List;

public class TemperatureMonitorImpl implements TemperatureMonitor {
    private final List<TemperatureObserver> observerList;
    private final TemperatureState state;
    private final Long code;
    private final DataCenterConnection dataCenterConnection;
    private Long patientId;
    private TemperatureConfig config;
    private TemperatureDriver runnable;
    private boolean isRunning;

    public TemperatureMonitorImpl(Long code) {
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.code = code;
        this.isRunning = false;
        observerList = new ArrayList<>();

        state = new TemperatureState();
        state.setTemperature(0);

        config = new TemperatureConfig();
        config.setPatientId(0L);
        final TemperatureState maxState = new TemperatureState();
        maxState.setTemperature(Integer.MAX_VALUE);
        config.setMinState(maxState);
        final TemperatureState minState = new TemperatureState();
        minState.setTemperature(Integer.MIN_VALUE);
        config.setMinState(minState);
    }

    @Override
    public void start(Long patientId) {
        runnable = new TemperatureDriver(temperature -> {
            handleTemperatureRead(temperature);
            return null;
        });
        final Thread thread = new Thread(runnable);
        thread.start();
        isRunning = true;
        this.patientId = patientId;
    }

    @Override
    public void stop() {
        observerList.clear();
        runnable.kill();
        isRunning = false;
    }

    @Override
    public void configure(TemperatureConfig config) {
        this.config = config;
    }

    @Override
    public void addObserver(TemperatureObserver observer) {
        observerList.add(observer);
    }

    @Override
    public TemperatureState getCurrentState() {
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

    private void handleTemperatureRead(int temperature) {
        final TemperatureAlertType alertType = checkShouldAlert(temperature);
        if (alertType != null) {
            saveLog("Alerta: " + alertType.getValue());
            observerList.forEach(observer -> observer.alert(alertType, patientId));
        }
    }

    private TemperatureAlertType checkShouldAlert(int temperature) {
        saveLog("Temperatura: " + temperature + "ºC");
        state.setTemperature(temperature);
        if (temperature > config.getMaxState().getTemperature()) {
            return TemperatureAlertType.MAX;
        } else if (temperature < config.getMinState().getTemperature()) {
            return TemperatureAlertType.MIN;
        }

        return null;
    }

    private void saveLog(String info) {
        dataCenterConnection.getPatientLogController().saveLog(patientId, "Monitor de Temperatura", info);
    }
}
