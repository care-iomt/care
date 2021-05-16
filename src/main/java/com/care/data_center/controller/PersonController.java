package com.care.data_center.controller;

import com.care.data_center.entities.Person;

import java.util.List;

public interface PersonController {
    /**
     * Salva uma nova pessoa
     *
     * @param person pessoa
     */
    void save(Person person);

    /**
     * Retorna todas as pessoas
     *
     * @return lista com todas as pessoas cadastradas
     */
    List<Person> getAll();
}
