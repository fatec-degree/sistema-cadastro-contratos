package com.fatec.contracts.controller.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
public class ConfigRequestDto {

    private String cnpj;
    private String corporateName;
    private String representativeName;
    private String representativeRg;
    private String representativeCpf;
    private LocalDate representativeDateOfBirth;
    private String representativeMainContact;
    private String representativeSecondaryContact;
    private String representativeEmail;
    private String representativeZipCode;
    private String representativeStreet;
    private String representativeDistrict;
    private String representativeCity;
    private String representativeHouseNumber;
    private String representativeState;

}
