package alert_button;

import data_center.DataCenterConnection;

import java.util.List;

public class AlertButtonRunnable implements Runnable {
    private final List<AlertButtonObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long code;
    private boolean isRunning;

    public AlertButtonRunnable(List<AlertButtonObserver> observerList, Long code) {
        this.observerList = observerList;
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.code = code;
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                if (this.shouldReport()) {
                    dataCenterConnection.getButtonLogController().saveLog(code, "botão disparado");
                    observerList.forEach(observer -> observer.alert(this.code));
                }
                Thread.sleep(5000);
            } catch (InterruptedException ignored) { }
        }
    }

    private boolean shouldReport() {
        return ((int) (Math.random() * 11)) == 3;
    }
}
