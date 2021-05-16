package blood_pressure;

public class BloodPressureState {
    private Integer systolic;
    private Integer diastolic;

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    @Override
    public String toString() {
        return "Sistólica=" + systolic +
                "/Diastólica=" + diastolic;
    }
}
