package blood_pressure;

import java.util.ArrayList;
import java.util.List;

public class BloodPressureMonitorImpl implements BloodPressureMonitor {
    private final List<BloodPressureObserver> observerList;
    private final BloodPressureState state;
    private final Long code;
    private Long patientId;
    private BloodPressureRunnable runnable;
    private BloodPressureConfig config;
    private boolean isRunning;

    public BloodPressureMonitorImpl(Long code) {
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
        runnable = new BloodPressureRunnable(observerList, patientId, config, state);
        final Thread thread = new Thread(runnable);
        thread.start();
        isRunning = true;
        this.patientId = patientId;
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
}
