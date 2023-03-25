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
    @OneToOne
    private Student student;
    private BigDecimal amount;
    private LocalDate firstParcel;
    private Integer collectionDay;
    private Integer numberOfParcels;
    private BigDecimal parcelValue;
    private Integer year;
    private LocalDate start = LocalDate.now();
    private LocalDate end;
    private boolean expired = false;

}
