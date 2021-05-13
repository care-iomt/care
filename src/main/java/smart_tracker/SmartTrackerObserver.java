package smart_tracker;

public interface SmartTrackerObserver {
    void alert(SmartTrackerAlertType alertType);
}