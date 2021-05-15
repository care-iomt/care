package app.observers;

import temperature_monitor.TemperatureAlertType;
import temperature_monitor.TemperatureObserver;

public class TemperatureObserverImpl implements TemperatureObserver {
    @Override
    public void alert(TemperatureAlertType alertType) {
        System.out.println("Temperature alert type: " + alertType.getValue());
    }
}
