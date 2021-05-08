package temperature_monitor;

public interface Observer {
    void alert(AlertType alertType);
}