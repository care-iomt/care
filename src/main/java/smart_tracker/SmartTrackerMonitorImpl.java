package smart_tracker;

import data_center.DataCenterConnection;
import java.util.ArrayList;
import java.util.List;

public class SmartTrackerMonitorImpl implements SmartTrackerMonitor {
    private final DataCenterConnection dataCenterConnection;
    private final List<SmartTrackerObserver> observerList;
    private final Long code;
    private SmartTrackerConfig config;
    private SmartTrackerRunnable runnable;
    private boolean isRunning;

    public SmartTrackerMonitorImpl(DataCenterConnection dataCenterConnection, Long code) {
        this.dataCenterConnection = dataCenterConnection;
        this.code = code;
        this.isRunning = false;
        observerList = new ArrayList<>();
        config = new SmartTrackerConfig();
        config.setPermission(SmartTrackerPermission.NONE);
    }

    @Override
    public void configure(SmartTrackerConfig config) {
        this.config = config;
    }

    @Override
    public void addObserver(SmartTrackerObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(SmartTrackerObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public void start(Long patientId) {
        runnable = new SmartTrackerRunnable(observerList, patientId);
        final Thread thread = new Thread(runnable);
        thread.start();
        isRunning = true;
    }

    @Override
    public void stop() {
        runnable.kill();
        isRunning = false;
    }

    @Override
    public boolean isUsed() {
        return isRunning;
    }
}
