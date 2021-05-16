package com.care.data_center.entities;

public class Person {
    private String name;
    private String cpf;

    public Person() {
    }

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }
}
