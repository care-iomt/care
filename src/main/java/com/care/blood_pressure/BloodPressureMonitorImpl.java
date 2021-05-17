package com.care.blood_pressure;

import com.care.data_center.DataCenterConnection;
import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayList;
import java.util.List;

public class BloodPressureMonitorImpl implements BloodPressureMonitor {
    private final List<BloodPressureObserver> observerList;
    private final BloodPressureState state;
    private final Long code;
    private final DataCenterConnection dataCenterConnection;
    private Long patientId;
    private BloodPressureDriver runnable;
    private BloodPressureConfig config;
    private boolean isRunning;

    public BloodPressureMonitorImpl(Long code) {
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.code = code;
        this.isRunning = false;

        observerList = new ArrayList<>();

        state = new BloodPressureState();
        state.setSystolic(0);
        state.setDiastolic(0);

        config = new BloodPressureConfig();

        final BloodPressureState maxState = new BloodPressureState();
        maxState.setDiastolic(Integer.MAX_VALUE);
        maxState.setSystolic(Integer.MAX_VALUE);
        config.setMaxState(maxState);

        final BloodPressureState minState = new BloodPressureState();
        minState.setDiastolic(Integer.MIN_VALUE);
        minState.setSystolic(Integer.MIN_VALUE);
        config.setMinState(minState);
    }

    @Override
    public void start(Long patientId) {
        this.patientId = patientId;
        runnable = new BloodPressureDriver(bloodPressureRead -> {
            handleBloodPressureRead(bloodPressureRead);
            return null;
        });
        final Thread thread = new Thread(runnable);
        thread.start();
        isRunning = true;
    }

    @Override
    public void stop() {
        observerList.clear();
        isRunning = false;
        runnable.kill();
    }

    @Override
    public BloodPressureState getCurrentState() {
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
    public void addObserver(BloodPressureObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void configure(BloodPressureConfig config) {
        this.config = config;
    }

    private void handleBloodPressureRead(Pair<Integer, Integer> bloodPressure) {
        final BloodPressureAlertType alertType = checkShouldAlert(bloodPressure);
        if (alertType != null) {
            saveLog("Alerta " + alertType.getValue());
            observerList.forEach(observer -> observer.alert(alertType, patientId));
        }
    }

    private BloodPressureAlertType checkShouldAlert(Pair<Integer, Integer> bloodPressure) {
        final int systolic = bloodPressure.getLeft();
        final int diastolic = bloodPressure.getRight();

        saveLog("Sistólica: " + systolic + " - Diastólica: " + diastolic);

        state.setDiastolic(diastolic);
        state.setSystolic(systolic);

        if (diastolic < config.getMinState().getDiastolic()) {
            return BloodPressureAlertType.MIN_DIASTOLIC;
        } else if (diastolic > config.getMaxState().getDiastolic()) {
            return BloodPressureAlertType.MAX_DIASTOLIC;
        } else if (systolic < config.getMinState().getSystolic()) {
            return BloodPressureAlertType.MIN_SYSTOLIC;
        } else if (systolic > config.getMaxState().getSystolic()) {
            return BloodPressureAlertType.MAX_SYSTOLIC;
        }

        return null;
    }

    private void saveLog(String info) {
        dataCenterConnection.getPatientLogController().saveLog(patientId, "Monitor de Pressão", info);
    }
}
