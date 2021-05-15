package data_center.entities;

import app.utils.StringUtils;

public class Patient {
    private Long patientId;
    private String name;
    private String cpf;

    public Patient(String name, String cpf) {
        this.patientId = StringUtils.cpfToLong(cpf);
        this.name = name;
        this.cpf = cpf;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
