package blood_pressure;

import data_center.DataCenterConnection;
import java.util.ArrayList;
import java.util.List;

public class BloodPressureMonitorImpl implements BloodPressureMonitor {
    private final DataCenterConnection dataCenterConnection;
    private final List<BloodPressureObserver> observerList;
    private final BloodPressureState state;
    private BloodPressureRunnable runnable;
    private BloodPressureConfig config;

    public BloodPressureMonitorImpl(DataCenterConnection dataCenterConnection) {
        this.dataCenterConnection = dataCenterConnection;

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
        runnable = new BloodPressureRunnable(observerList, dataCenterConnection, patientId);
        final Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void stop() {
        runnable.stop();
    }

    @Override
    public BloodPressureState getCurrentState() {
        return state;
    }

    @Override
    public void addObserver(BloodPressureObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(BloodPressureObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void configure(BloodPressureConfig config) {
        this.config = config;
    }
}
