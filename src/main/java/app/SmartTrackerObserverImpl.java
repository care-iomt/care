package app;

import smart_tracker.SmartTrackerAlertType;
import smart_tracker.SmartTrackerObserver;

public class SmartTrackerObserverImpl implements SmartTrackerObserver {
    @Override
    public void alert(SmartTrackerAlertType alertType) {
        System.out.println("Smart tracker alert: " + alertType.getValue());
    }
}
