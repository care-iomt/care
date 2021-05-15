package temperature_monitor;

public interface TemperatureObserver {
    void alert(TemperatureAlertType alertType, Long patientId);
}