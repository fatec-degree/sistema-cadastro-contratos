package com.fatec.contracts.controller.dto.request;

import jakarta.validation.constraints.*;
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

    @NotBlank
    private String studentName;
    @NotBlank
    private String studentRg;
    @NotBlank
    private String studentCpf;
    @NotNull @Past
    private LocalDate studentDateOfBirth;
    @NotBlank
    private String studentZipCode;
    @NotBlank
    private String studentStreet;
    @NotBlank
    private String studentHouseNumber;
    @NotBlank
    private String studentDistrict;
    @NotBlank
    private String studentCity;
    @NotBlank
    private String studentState;
    private String studentSickness;
    private String studentAllergies;
    private String studentMedicines;
    private String studentHealthRemarks;
    @NotBlank
    private String schoolName;
    @NotBlank
    private String schoolZipCode;
    @NotBlank
    private String schoolStreet;
    @NotBlank
    private String schoolNumber;
    @NotBlank
    private String schoolDistrict;
    @NotBlank
    private String schoolCity;
    private String schoolState;
    @NotNull
    private LocalTime entryTime;
    @NotNull
    private LocalTime departureTime;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String responsibleRelationship;
    @NotBlank
    private String responsibleRg;
    @NotBlank
    private String responsibleCpf;
    @Past
    private LocalDate responsibleDateOfBirth;
    @NotBlank
    private String responsibleMainContact;
    private String responsibleSecondaryContact;
    @NotBlank @Email
    private String responsibleEmail;
    private String responsibleEmergencyContact;
    @NotNull @Positive
    private BigDecimal amount;
    @NotNull @FutureOrPresent
    private LocalDate firstParcel;
    @NotNull @Min(value = 1) @Max(value = 31)
    private Integer collectionDay;
    @NotNull @Min(value = 6) @Max(value = 12)
    private Integer numberOfParcels;
    @NotNull @Positive
    private BigDecimal parcelValue;
    @NotNull @Positive
    private Integer year;

}
