package heart_rate;

import java.util.ArrayList;
import java.util.List;

public class HeartRateMonitorImpl implements HeartRateMonitor {
    private final List<HeartRateObserver> observerList;
    private final HeartRateState state;
    private final Long code;
    private Long patientId;
    private HeartRateConfig config;
    private HeartRateRunnable runnable;
    private boolean isRunning;

    public HeartRateMonitorImpl(Long code) {
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
        runnable = new HeartRateRunnable(observerList, patientId, state, config);
        final Thread thread = new Thread(runnable);
        thread.start();
        this.patientId = patientId;
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
}
