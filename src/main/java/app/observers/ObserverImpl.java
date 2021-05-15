package app.observers;

public abstract class ObserverImpl {
    private Long patientId;

    public ObserverImpl(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }
}
