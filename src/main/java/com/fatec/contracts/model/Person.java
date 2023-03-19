package com.fatec.contracts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "persons")
@Embeddable
public class Person extends AbstractPerson{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
