package com.fatec.contracts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "students")
public class Student extends AbstractPerson {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Responsible responsible;
    @OneToOne
    private Schedule schedule;
    @OneToOne
    private HealthCondition healthCondition;

}
