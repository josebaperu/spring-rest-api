package com.spring.rest.repository;

import com.spring.rest.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> findByName(String name);

    Optional<Person> findById(String id);
}