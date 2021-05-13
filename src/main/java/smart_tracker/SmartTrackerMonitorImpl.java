package smart_tracker;

import data_center.DataCenterConnection;

import java.util.ArrayList;
import java.util.List;

public class SmartTrackerMonitorImpl implements SmartTrackerMonitor {
    private final DataCenterConnection dataCenterConnection;
    private final List<SmartTrackerObserver> observerList;
    private SmartTrackerConfig config;

    public SmartTrackerMonitorImpl(DataCenterConnection dataCenterConnection) {
        this.dataCenterConnection = dataCenterConnection;
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

    //TODO Thread de eventos
}
