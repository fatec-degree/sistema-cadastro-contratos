package com.fatec.contracts.model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractPerson {

    private String name;
    private String rg;
    private String cpf;
    private LocalDate dateOfBirth;
    private String mainContact;
    private String secondaryContact;
    private String email;
    @ManyToOne
    private Address address;

}
