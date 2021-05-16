package smart_tracker;

import java.util.ArrayList;
import java.util.List;

public class SmartTrackerMonitorImpl implements SmartTrackerMonitor {
    private final List<SmartTrackerObserver> observerList;
    private final Long code;
    private SmartTrackerRunnable runnable;
    private boolean isRunning;

    public SmartTrackerMonitorImpl(Long code) {
        this.code = code;
        this.isRunning = false;
        observerList = new ArrayList<>();
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
