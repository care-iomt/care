package app.observers;

import app.ui.Notifier;
import data_center.DataCenterConnection;
import data_center.entities.Patient;
import heart_rate.HeartRateAlertType;
import heart_rate.HeartRateObserver;

public class HeartRateObserverImpl extends ObserverImpl implements HeartRateObserver {
    public HeartRateObserverImpl(Long patientId) {
        super(patientId);
    }

    @Override
    public void alert(HeartRateAlertType alertType, Long patientId) {
        Patient patient = findPatientInDataCenter(patientId);
        Notifier.alertDoctor("ALERTA: HeartRate",
                "Paciente " + patient.getName()+ "; Descrição: "+alertType.getDescription());
    }

    private static Patient findPatientInDataCenter(Long patientId) {
        DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        return dataCenterConnection.getPatientController().getById(patientId);
    }
}