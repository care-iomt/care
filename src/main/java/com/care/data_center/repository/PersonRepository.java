package com.care.data_center.repository;

import com.care.data_center.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private final List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>();
    }

    public void save(Person person) {
        persons.add(person);
    }

    public List<Person> findAll() {
        return persons;
    }
}
