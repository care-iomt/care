package temperature_monitor;

import java.util.ArrayList;
import java.util.List;

public class TemperatureMonitorImpl implements TemperatureMonitor {
    private final List<TemperatureObserver> observerList;
    private final TemperatureState state;
    private final Long code;
    private Long patientId;
    private TemperatureConfig config;
    private TemperatureRunnable runnable;
    private boolean isRunning;

    public TemperatureMonitorImpl(Long code) {
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
        runnable = new TemperatureRunnable(observerList, patientId, config, state);
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
    public void removeObserver(TemperatureObserver observer) {
        observerList.remove(observer);
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
}
