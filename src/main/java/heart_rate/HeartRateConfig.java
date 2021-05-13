package heart_rate;

public class HeartRateConfig {
    private Long patientId;
    private HeartRateState minState;
    private HeartRateState maxState;

    public HeartRateConfig() { }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public HeartRateState getMinState() {
        return minState;
    }

    public void setMinState(HeartRateState minState) {
        this.minState = minState;
    }

    public HeartRateState getMaxState() {
        return maxState;
    }

    public void setMaxState(HeartRateState maxState) {
        this.maxState = maxState;
    }
}
