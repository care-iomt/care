package app.observers;

import smart_tracker.SmartTrackerAlertType;
import smart_tracker.SmartTrackerObserver;

public class SmartTrackerObserverImpl extends ObserverImpl implements SmartTrackerObserver {

    public SmartTrackerObserverImpl(Long patientId, Long monitorCode) {
        super(patientId, monitorCode);
    }

    @Override
    public void alert(SmartTrackerAlertType alertType, Long patientId) {

    }
}
