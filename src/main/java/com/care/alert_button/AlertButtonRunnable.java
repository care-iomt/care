package com.care.alert_button;

import com.care.data_center.DataCenterConnection;

import java.util.List;

public class AlertButtonRunnable implements Runnable {
    private final List<AlertButtonObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long code;

    public AlertButtonRunnable(List<AlertButtonObserver> observerList, Long code) {
        this.observerList = observerList;
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.code = code;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (this.shouldReport()) {
                    dataCenterConnection.getButtonLogController().saveLog(code, "botão disparado");
                    observerList.forEach(observer -> observer.alert(this.code));
                }
                Thread.sleep(120000);
            } catch (InterruptedException ignored) { }
        }
    }

    private boolean shouldReport() {
        return ((int) (Math.random() * 11)) == 3;
    }
}
