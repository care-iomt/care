package alert_button;

import data_center.DataCenterConnection;

import java.util.List;

public class AlertButtonRunnable implements Runnable {
    private final List<AlertButtonObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long id;
    private boolean isRunning;

    public AlertButtonRunnable(List<AlertButtonObserver> observerList, Long id, DataCenterConnection dataCenterConnection) {
        this.observerList = observerList;
        this.dataCenterConnection = dataCenterConnection;
        this.id = id;
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
                    dataCenterConnection.getButtonLogController().saveLog(id, "botão disparado");
                    observerList.forEach(AlertButtonObserver::alert);
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private boolean shouldReport() {
        return ((int) (Math.random() * 11)) == 3;
    }
}
