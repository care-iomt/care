package app.observers;

import app.ui.Notifier;
import data_center.DataCenterConnection;
import data_center.entities.Patient;
import temperature_monitor.TemperatureAlertType;
import temperature_monitor.TemperatureObserver;

public class TemperatureObserverImpl extends ObserverImpl implements TemperatureObserver {
    public TemperatureObserverImpl(Long patientId) {
        super(patientId);
    }

    @Override
    public void alert(TemperatureAlertType alertType, Long patientId) {
        Patient patient = findPatientInDataCenter(patientId);
        Notifier.alertDoctor("ALERTA: TemperatureSensor",
                "Paciente " + patient.getName()+ "; Descrição: "+alertType.getDescription());
    }

    private static Patient findPatientInDataCenter(Long patientId) {
        DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        return dataCenterConnection.getPatientController().getById(patientId);
    }
}
