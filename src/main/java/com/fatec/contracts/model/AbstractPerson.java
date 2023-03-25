package com.fatec.contracts.model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
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

    public String getContacts() {
        return !secondaryContact.isEmpty() ? mainContact + ", " + secondaryContact : mainContact;
    }

}
