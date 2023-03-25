package com.fatec.contracts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime entry;
    private LocalTime departure;
    @ManyToOne
    private School school;

    public String getCompletePeriod() {
        return entry + " as " + departure;
    }
}
