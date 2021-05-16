package com.care.app.observers;

import com.care.app.ui.Notifier;
import com.care.data_center.DataCenterConnection;
import com.care.data_center.entities.Patient;
import com.care.heart_rate.HeartRateAlertType;
import com.care.heart_rate.HeartRateObserver;

public class HeartRateObserverImpl extends ObserverImpl implements HeartRateObserver {
    public HeartRateObserverImpl(Long patientId, Long monitorCode) {
        super(patientId, monitorCode);
    }


    @Override
    public void alert(HeartRateAlertType alertType, Long patientId) {
        Patient patient = findPatientInDataCenter(patientId);
        Notifier.alertDoctor("ALERTA: HeartRate",
                "Paciente " + patient.getName() + "; Descrição: " + alertType.getDescription());
    }

    private static Patient findPatientInDataCenter(Long patientId) {
        DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        return dataCenterConnection.getPatientController().getById(patientId);
    }
}