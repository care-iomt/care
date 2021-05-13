package alert_button;

import data_center.DataCenterConnection;

import java.util.ArrayList;
import java.util.List;

public class AlertButtonMonitorImpl implements AlertButtonMonitor {
    private final List<AlertButtonObserver> observerList;

    public AlertButtonMonitorImpl(Long id, DataCenterConnection dataCenterConnection) {
        observerList = new ArrayList<>();
        final AlertButtonRunnable runnable = new AlertButtonRunnable(observerList, id, dataCenterConnection);
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
}
