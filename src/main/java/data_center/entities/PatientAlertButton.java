package data_center.entities;

public class PatientAlertButton {
    private Patient patient;
    private Long alertButtonCode;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getAlertButtonCode() {
        return alertButtonCode;
    }

    public void setAlertButtonCode(Long alertButtonCode) {
        this.alertButtonCode = alertButtonCode;
    }
}
