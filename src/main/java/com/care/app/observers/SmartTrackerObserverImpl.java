package com.care.app.observers;

import com.care.app.ui.Notifier;
import com.care.data_center.entities.Patient;
import com.care.smart_tracker.SmartTrackerAlertType;
import com.care.smart_tracker.SmartTrackerObserver;

public class SmartTrackerObserverImpl extends ObserverImpl implements SmartTrackerObserver {

    public SmartTrackerObserverImpl(Long patientId, Long monitorCode) {
        super(patientId, monitorCode);
    }

    @Override
    public void alert(SmartTrackerAlertType alertType, Long patientId) {
        Patient patient = findPatientInDataCenter(patientId);
        Notifier.alertDoctor("ALERTA: SmartTracker",
                "Paciente " + patient.getName() + "; Descrição: " + alertType.getDescription());
    }
}
