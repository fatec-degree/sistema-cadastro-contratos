package com.fatec.contracts.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ContractDto {

    private String studentName;
    private String studentRg;
    private String studentCpf;
    private LocalDate studentDateOfBirth;
    private String studentZipCode;
    private String studentStreet;
    private String studentHouseNumber;
    private String studentDistrict;
    private String studentCity;
    private String studentState;
    private String studentSickness;
    private String studentAllergies;
    private String studentMedicines;
    private String studentHealthRemarks;
    private String schoolName;
    private String schoolZipCode;
    private String schoolStreet;
    private String schoolNumber;
    private String schoolDistrict;
    private String schoolCity;
    private String schoolState;
    private LocalTime entryTime;
    private LocalTime departureTime;
    private String responsibleName;
    private String responsibleRelationship;
    private String responsibleRg;
    private String responsibleCpf;
    private LocalDate responsibleDateOfBirth;
    private String responsibleMainContact;
    private String responsibleSecondaryContact;
    private String responsibleEmail;
    private String responsibleRemarks;
    private BigDecimal amount;
    private LocalDate firstParcel;
    private Integer collectionDay;
    private BigDecimal parcelValue;
    private Integer year;

}
