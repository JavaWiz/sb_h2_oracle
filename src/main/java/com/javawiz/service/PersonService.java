package com.javawiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawiz.entity.Person;
import com.javawiz.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).get();
    }

    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}