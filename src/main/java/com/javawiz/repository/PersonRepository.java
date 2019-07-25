package com.javawiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.javawiz.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {}  