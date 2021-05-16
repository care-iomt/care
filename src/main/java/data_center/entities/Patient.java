package data_center.entities;

import data_center.utils.StringUtils;

public class Patient extends Person {
    private Long patientId;

    public Patient(String name, String cpf) {
        super(name, cpf);
        this.patientId = StringUtils.cpfToLong(cpf);
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
