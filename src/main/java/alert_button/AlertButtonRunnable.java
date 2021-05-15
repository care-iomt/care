package alert_button;

import data_center.DataCenterConnection;

import java.util.List;

public class AlertButtonRunnable implements Runnable {
    private final List<AlertButtonObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long code;
    private boolean isRunning;

    public AlertButtonRunnable(List<AlertButtonObserver> observerList, Long code, DataCenterConnection dataCenterConnection) {
        this.observerList = observerList;
        this.dataCenterConnection = dataCenterConnection;
        this.code = code;
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(5000);
                if (this.shouldReport()) {
                    dataCenterConnection.getButtonLogController().saveLog(code, "botão disparado");
                    observerList.forEach(observer -> observer.alert(this.code));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private boolean shouldReport() {
        return ((int) (Math.random() * 11)) == 3;
    }
}
