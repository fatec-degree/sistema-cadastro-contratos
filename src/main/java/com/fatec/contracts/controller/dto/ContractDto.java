package com.fatec.contracts.controller.dto;

import com.fatec.contracts.model.*;
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
    private LocalTime entryTime;
    private LocalTime departureTime;
    private String responsibleName;
    private String responsibleRg;
    private String responsibleCpf;
    private LocalDate responsibleDateOfBirth;
    private String responsibleMainContact;
    private String responsibleSecondaryContact;
    private String responsibleEmail;
    private String responsibleRemarks;
    private BigDecimal amount;
    private Integer year;

    public Contract toContract() {
        Address studentAddress = new Address();
        studentAddress.setZipCode(this.studentZipCode);
        studentAddress.setNumber(this.studentHouseNumber);
        studentAddress.setStreet(this.studentStreet);
        studentAddress.setDistrict(this.studentDistrict);
        studentAddress.setCity(this.studentCity);

        HealthCondition healthCondition = new HealthCondition();
        healthCondition.setSickness(this.studentSickness);
        healthCondition.setAllergies(this.studentAllergies);
        healthCondition.setMedicines(this.studentMedicines);
        healthCondition.setRemarks(this.studentHealthRemarks);

        Address schoolAddress = new Address();
        schoolAddress.setZipCode(this.schoolZipCode);
        schoolAddress.setNumber(this.schoolNumber);
        schoolAddress.setStreet(this.schoolStreet);
        schoolAddress.setDistrict(this.schoolDistrict);
        schoolAddress.setCity(this.schoolCity);

        School school = new School();
        school.setName(this.schoolName);
        school.setAddress(schoolAddress);

        Schedule schedule = new Schedule();
        schedule.setEntry(this.entryTime);
        schedule.setDeparture(this.departureTime);
        schedule.setSchool(school);

        Responsible responsible = new Responsible();
        responsible.setName(this.responsibleName);
        responsible.setRg(this.responsibleRg);
        responsible.setCpf(this.responsibleCpf);
        responsible.setDateOfBirth(this.responsibleDateOfBirth);
        responsible.setAddress(studentAddress);
        responsible.setMainContact(this.responsibleMainContact);
        responsible.setSecondaryContact(this.responsibleSecondaryContact);
        responsible.setEmail(this.responsibleEmail);
        responsible.setRemarks(this.responsibleRemarks);

        Student student = new Student();
        student.setName(this.studentName);
        student.setRg(this.studentRg);
        student.setCpf(this.studentCpf);
        student.setDateOfBirth(this.studentDateOfBirth);
        student.setAddress(studentAddress);
        student.setHealthCondition(healthCondition);
        student.setSchedule(schedule);
        student.setResponsible(responsible);

        Contract contract = new Contract();
        contract.setAmount(this.amount);
        contract.setYear(this.year);

        return contract;
    }

}
