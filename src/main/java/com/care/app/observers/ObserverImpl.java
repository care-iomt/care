package com.care.app.observers;

import com.care.data_center.DataCenterConnection;
import com.care.data_center.entities.Patient;

public abstract class ObserverImpl {
    private Long patientId;
    private Long monitorCode;

    public ObserverImpl(Long patientId, Long monitorCode) {
        this.patientId = patientId;
        this.monitorCode = monitorCode;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getMonitorCode() {
        return monitorCode;
    }

    protected static Patient findPatientInDataCenter(Long patientId) {
        DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        return dataCenterConnection.getPatientController().getById(patientId);
    }
}
