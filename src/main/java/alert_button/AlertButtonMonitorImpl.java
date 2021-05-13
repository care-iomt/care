package alert_button;

import data_center.DataCenterConnection;

import java.util.ArrayList;
import java.util.List;

public class AlertButtonMonitorImpl implements AlertButtonMonitor {
    private final List<AlertButtonObserver> observerList;
    private final DataCenterConnection dataCenterConnection;

    public AlertButtonMonitorImpl(DataCenterConnection dataCenterConnection) {
        observerList = new ArrayList<>();
        this.dataCenterConnection = dataCenterConnection;
    }

    @Override
    public void addObserver(AlertButtonObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(AlertButtonObserver observer) {
        observerList.remove(observer);
    }

    //TODO Thread que observa
}
