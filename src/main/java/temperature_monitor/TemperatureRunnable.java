package temperature_monitor;

import data_center.DataCenterConnection;
import java.util.List;

public class TemperatureRunnable implements Runnable {
    private final List<TemperatureObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final TemperatureState state;
    private final TemperatureConfig config;
    private final Long patientId;
    private boolean isRunning;

    public TemperatureRunnable(List<TemperatureObserver> observerList, Long patientId,
                               TemperatureConfig config, TemperatureState state) {
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
                Thread.sleep(60000);
                final TemperatureAlertType alertType = getAlertType();
                if (alertType != null) {
                    saveLog("Alerta: "+alertType.getValue());
                    observerList.forEach(observer -> observer.alert(alertType, patientId));
                }
            } catch (InterruptedException ignored) { }
        }
    }

    private TemperatureAlertType getAlertType() {
        final int temperature = (int) getRandomTemperature();
        saveLog("Temperatura: " + temperature + "ºC");
        state.setTemperature(temperature);
        if (temperature > config.getMaxState().getTemperature()) {
            return TemperatureAlertType.MAX;
        } else if (temperature < config.getMinState().getTemperature()) {
            return TemperatureAlertType.MIN;
        }

        return null;
    }

    private double getRandomTemperature() {
        final double rand = Math.random();
        if (rand < 0.9) {
            return (Math.random() * 2) + 35;
        } else if (rand < 0.98) {
            return (Math.random() * 3) + 32;
        } else {
            return (Math.random() * 5) + 37;
        }
    }

    private void saveLog(String info) {
        dataCenterConnection.getPatientLogController().saveLog(patientId, "Monitor de Temperatura", info);
    }
}
