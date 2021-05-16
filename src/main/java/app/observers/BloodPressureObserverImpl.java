package app.observers;

import app.ui.Notifier;
import blood_pressure.BloodPressureAlertType;
import blood_pressure.BloodPressureObserver;
import data_center.DataCenterConnection;
import data_center.entities.Patient;

public class BloodPressureObserverImpl extends ObserverImpl implements BloodPressureObserver {
    public BloodPressureObserverImpl(Long patientId) {
        super(patientId);
    }

    @Override
    public void alert(BloodPressureAlertType bloodPressureAlertType, Long patientId) {
        Patient patient = findPatientInDataCenter(patientId);
        Notifier.alertDoctor("ALERTAL: BloodPressure",
                "Paciente " + patient.getName()+ "; Descrição: "+bloodPressureAlertType.getDescription());
    }

    private static Patient findPatientInDataCenter(Long patientId) {
        DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        return dataCenterConnection.getPatientController().getById(patientId);
    }
}
