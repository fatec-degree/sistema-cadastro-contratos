package com.fatec.contracts.repository;

import com.fatec.contracts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
