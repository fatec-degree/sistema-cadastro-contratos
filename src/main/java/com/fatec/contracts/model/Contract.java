package com.fatec.contracts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "contracts")
public class Contract {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ServiceProvider serviceProvider;
    @OneToOne
    private Responsible responsible;
    private BigDecimal amount;
    private Integer currentYear;
    private LocalDate start;
    private LocalDate endDate;
    private boolean expired;

}
