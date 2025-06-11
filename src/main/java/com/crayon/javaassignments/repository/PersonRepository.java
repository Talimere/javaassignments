package com.crayon.javaassignments.repository;

import com.crayon.javaassignments.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
