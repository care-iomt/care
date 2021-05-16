package com.care.app.observers;

import com.care.app.ui.Notifier;
import com.care.data_center.DataCenterConnection;
import com.care.data_center.entities.Patient;
import com.care.temperature_monitor.TemperatureAlertType;
import com.care.temperature_monitor.TemperatureObserver;

public class TemperatureObserverImpl extends ObserverImpl implements TemperatureObserver {

    public TemperatureObserverImpl(Long patientId, Long monitorCode) {
        super(patientId, monitorCode);
    }

    @Override
    public void alert(TemperatureAlertType alertType, Long patientId) {
        Patient patient = findPatientInDataCenter(patientId);
        Notifier.alertDoctor("ALERTA: TemperatureSensor",
                "Paciente " + patient.getName() + "; Descrição: " + alertType.getDescription());
    }

    private static Patient findPatientInDataCenter(Long patientId) {
        DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        return dataCenterConnection.getPatientController().getById(patientId);
    }
}
