package heart_rate;

public class Config {
    private Long patientId;
    private State minState;
    private State maxState;

    public Config() { }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public State getMinState() {
        return minState;
    }

    public void setMinState(State minState) {
        this.minState = minState;
    }

    public State getMaxState() {
        return maxState;
    }

    public void setMaxState(State maxState) {
        this.maxState = maxState;
    }
}
