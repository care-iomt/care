package com.care.app.observers;

import com.care.alert_button.AlertButtonObserver;
import com.care.app.ui.Notifier;

public class AlertButtonObserverImpl extends ObserverImpl implements AlertButtonObserver {
    public AlertButtonObserverImpl(Long patientId, Long monitorCode) {
        super(patientId, monitorCode);
    }

    @Override
    public void alert(Long buttonCode) {
        Notifier.alertDoctor("ALERTA: EmergencyButton", "COD " + buttonCode);
    }
}
