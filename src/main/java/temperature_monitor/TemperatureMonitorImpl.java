package temperature_monitor;

import data_center.DataCenterConnection;
import java.util.ArrayList;
import java.util.List;

public class TemperatureMonitorImpl implements TemperatureMonitor {
    private final DataCenterConnection dataCenterConnection;
    private final List<TemperatureObserver> observerList;
    private final TemperatureState state;
    private TemperatureConfig config;
    private TemperatureMonitorRunnable runnable;

    public TemperatureMonitorImpl(DataCenterConnection dataCenterConnection) {
        this.dataCenterConnection = dataCenterConnection;

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
        runnable = new TemperatureMonitorRunnable(observerList, dataCenterConnection, patientId);
        final Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void stop() {
        runnable.stop();
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
}
