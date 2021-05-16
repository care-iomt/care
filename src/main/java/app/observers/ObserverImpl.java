package app.observers;

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
}
