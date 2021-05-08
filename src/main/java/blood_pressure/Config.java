package blood_pressure;

public class Config {
    private Long patientId;
    private State maxState;
    private State minState;

    public Config() { }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public State getMaxState() {
        return maxState;
    }

    public void setMaxState(State maxState) {
        this.maxState = maxState;
    }

    public State getMinState() {
        return minState;
    }

    public void setMinState(State minState) {
        this.minState = minState;
    }
}
