package com.digitalinnovation.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinnovation.personapi.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
