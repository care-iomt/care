package app.observers;

import alert_button.AlertButtonObserver;
import app.ui.Notifier;

public class AlertButtonObserverImpl extends ObserverImpl implements AlertButtonObserver {
    public AlertButtonObserverImpl(Long patientId) {
        super(patientId);
    }

    @Override
    public void alert(Long buttonCode) {
        Notifier.alertDoctor("EmergencyButton", "COD "+buttonCode);
    }
}
