package app.observers;

import smart_tracker.SmartTrackerAlertType;
import smart_tracker.SmartTrackerObserver;

public class SmartTrackerObserverImpl extends ObserverImpl implements SmartTrackerObserver {
    public SmartTrackerObserverImpl(Long patientId) {
        super(patientId);
    }

    @Override
    public void alert(SmartTrackerAlertType alertType, Long patientId) {

    }
}
