package com.care.app.observers;

import com.care.app.ui.Notifier;
import com.care.blood_pressure.BloodPressureAlertType;
import com.care.blood_pressure.BloodPressureObserver;
import com.care.data_center.entities.Patient;

public class BloodPressureObserverImpl extends ObserverImpl implements BloodPressureObserver {
    public BloodPressureObserverImpl(Long patientId, Long monitorCode) {
        super(patientId, monitorCode);
    }

    @Override
    public void alert(BloodPressureAlertType bloodPressureAlertType, Long patientId) {
        Patient patient = findPatientInDataCenter(patientId);
        Notifier.alertDoctor("ALERTAL: Monitor de Pressáo",
                "Paciente " + patient.getName() + "; Descrição: " + bloodPressureAlertType.getDescription());
    }
}
