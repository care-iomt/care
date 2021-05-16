package smart_camera;

import java.util.ArrayList;
import java.util.List;

public class SmartCameraMonitorImpl implements SmartCameraMonitor {
    private final List<SmartCameraObserver> observers;
    private SmartCameraConfig config;
    private SmartCameraRunnable runnable;

    public SmartCameraMonitorImpl() {
        this.observers = new ArrayList<>();
        this.config = new SmartCameraConfig("None");
    }

    @Override
    public void configure(SmartCameraConfig config) {
        config = config;
    }

    @Override
    public void addObserver(SmartCameraObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SmartCameraObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void start() {
        runnable = new SmartCameraRunnable(observers, config);
        final Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void stop() {
        runnable.kill();
    }
}
