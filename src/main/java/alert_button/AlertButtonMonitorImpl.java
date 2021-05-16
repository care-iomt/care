package alert_button;

import java.util.ArrayList;
import java.util.List;

public class AlertButtonMonitorImpl implements AlertButtonMonitor {
    private final List<AlertButtonObserver> observerList;
    private final Long code;

    public AlertButtonMonitorImpl(Long code) {
        this.code = code;
        observerList = new ArrayList<>();
        final AlertButtonRunnable runnable = new AlertButtonRunnable(observerList, code);
        final Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void addObserver(AlertButtonObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(AlertButtonObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public Long getCode() {
        return code;
    }
}
