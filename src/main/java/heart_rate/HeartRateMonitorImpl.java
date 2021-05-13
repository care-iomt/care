package heart_rate;

import data_center.DataCenterConnection;

import java.util.ArrayList;
import java.util.List;

public class HeartRateMonitorImpl implements HeartRateMonitor {
    private final DataCenterConnection dataCenterConnection;
    private final List<HeartRateObserver> observerList;
    private final HeartRateState state;
    private HeartRateConfig config;
    private boolean isRunning;

    public HeartRateMonitorImpl(DataCenterConnection dataCenterConnection) {
        this.dataCenterConnection = dataCenterConnection;

        observerList = new ArrayList<>();
        isRunning = false;

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
    public void start() {
        isRunning = true;
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public HeartRateState getCurrentState() {
        return state;
    }

    @Override
    public void addObserver(HeartRateObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(HeartRateObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void configure(HeartRateConfig config) {
        this.config = config;
    }

    //TODO Thread que observa
}
