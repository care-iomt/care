package data_center.controller;

import data_center.entities.Person;
import data_center.repository.PersonRepository;

import java.util.List;

public class PersonControllerImpl implements PersonController {
    private final PersonRepository personRepository;

    public PersonControllerImpl() {
        personRepository = new PersonRepository();
    }

    @Override
    public void save(Person person) {

    }

    @Override
    public List<Person> getAll() {
        return null;
    }
}
