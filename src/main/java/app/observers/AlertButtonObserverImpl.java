package app.observers;

import alert_button.AlertButtonObserver;
import app.ui.Notifier;

public class AlertButtonObserverImpl extends ObserverImpl implements AlertButtonObserver {
    public AlertButtonObserverImpl(Long patientId, Long monitorCode) {
        super(patientId, monitorCode);
    }

    @Override
    public void alert(Long buttonCode) {
        Notifier.alertDoctor("ALERTA: EmergencyButton", "COD "+buttonCode);
    }
}
