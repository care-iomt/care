package com.care.alert_button;

import com.care.data_center.DataCenterConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AlertButtonMonitorImpl implements AlertButtonMonitor {
    private final List<AlertButtonObserver> observerList;
    private final Long code;
    private final DataCenterConnection dataCenterConnection;

    public AlertButtonMonitorImpl(Long code) {
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.code = code;
        observerList = new ArrayList<>();
        final AlertButtonDriver runnable = new AlertButtonDriver(unused -> {
            handleAlertButtonClick();
            return null;
        });
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

    private void handleAlertButtonClick() {
        dataCenterConnection.getButtonLogController().saveLog(code, "Botão de emergência pressionado");
        observerList.forEach(observer -> observer.alert(this.code));
    }
}
