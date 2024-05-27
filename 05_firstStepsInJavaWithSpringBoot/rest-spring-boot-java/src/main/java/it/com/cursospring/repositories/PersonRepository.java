package it.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.com.cursospring.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
