package com.fatec.contracts.service;

import com.fatec.contracts.model.Person;
import com.fatec.contracts.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PersonService {

    private PersonRepository personRepository;

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
    }

    public Person save(Person person) {
        return this.personRepository.save(person);
    }

}
