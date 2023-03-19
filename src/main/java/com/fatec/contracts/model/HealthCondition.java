package com.fatec.contracts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "health_conditions")
public class HealthCondition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sickness;
    private String allergies;
    private String medicines;
    private String remarks;

}
