package heart_rate;

import data_center.DataCenterConnection;
import java.util.List;

public class HeartRateRunnable implements Runnable {
    private final List<HeartRateObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final HeartRateState state;
    private final HeartRateConfig config;
    private final Long patientId;
    private boolean isRunning;

    public HeartRateRunnable(List<HeartRateObserver> observerList, Long patientId,
                             HeartRateState state, HeartRateConfig config) {
        this.state = state;
        this.config = config;
        this.observerList = observerList;
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.patientId = patientId;
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                final HeartRateAlertType alertType = getAlertType();
                if (alertType != null) {
                    saveLog("Alerta: " + alertType.getValue());
                    observerList.forEach(observer -> observer.alert(alertType, patientId));
                }
                Thread.sleep(120000);
            } catch (InterruptedException ignored) { }
        }
    }

    private HeartRateAlertType getAlertType() {
        final int heartRate = getHeartRate();
        state.setHeartRate(heartRate);
        saveLog("Batimentos: " + heartRate);
        if (heartRate > config.getMaxState().getHeartRate()) {
            return HeartRateAlertType.MAX;
        } else if (heartRate < config.getMinState().getHeartRate()) {
            return HeartRateAlertType.MIN;
        } else {
            return null;
        }
    }

    private int getHeartRate() {
        final double rand = Math.random();
        if (rand < 0.65) {
            return (int)(Math.random() * 20) + 50;
        }  else if (rand < 0.90) {
            return (int)(Math.random() * 10) + 70;
        } else if (rand < 0.95) {
            return (int)(Math.random() * 20) + 30;
        } else {
            return (int)(Math.random() * 50) + 80;
        }
    }

    private void saveLog(String info) {
        dataCenterConnection.getPatientLogController().saveLog(patientId, "Monitor de Batimentos", info);
    }
}
