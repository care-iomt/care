package smart_tracker;

import heart_rate.AlertType;

public interface Observer {
    void alert(AlertType alertType);
}