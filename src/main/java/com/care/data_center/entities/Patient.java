package com.care.data_center.entities;

import com.care.data_center.utils.StringUtils;

public class Patient {
    private String name;
    private String cpf;
    private Long patientId;

    public Patient(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
        this.patientId = StringUtils.cpfToLong(cpf);
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
