package com.fatec.contracts.controller.dto.response;

import com.fatec.contracts.model.Contract;
import com.fatec.contracts.model.ContractStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class ContractDetailsResponseDto {

    private Long id;
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
    private String responsibleEmergencyContact;
    private String responsibleRemarks;
    private BigDecimal amount;
    private LocalDate firstParcel;
    private Integer collectionDay;
    private Integer numberOfParcels;
    private BigDecimal parcelValue;
    private Integer year;
    private ContractStatus status;

    public static ContractDetailsResponseDto toContractDetailsResponseDto(Contract contract) {
        ContractDetailsResponseDto contractDetailsResponseDto = new ContractDetailsResponseDto();
        contractDetailsResponseDto.setId(contract.getId());
        contractDetailsResponseDto.setStudentName(contract.getStudent().getName());
        contractDetailsResponseDto.setStudentRg(contract.getStudent().getRg());
        contractDetailsResponseDto.setStudentCpf(contract.getStudent().getCpf());
        contractDetailsResponseDto.setStudentDateOfBirth(contract.getStudent().getDateOfBirth());
        contractDetailsResponseDto.setStudentZipCode(contract.getStudent().getAddress().getZipCode());
        contractDetailsResponseDto.setStudentStreet(contract.getStudent().getAddress().getStreet());
        contractDetailsResponseDto.setStudentHouseNumber(contract.getStudent().getAddress().getNumber());
        contractDetailsResponseDto.setStudentDistrict(contract.getStudent().getAddress().getDistrict());
        contractDetailsResponseDto.setStudentCity(contract.getStudent().getAddress().getCity());
        contractDetailsResponseDto.setStudentState(contract.getStudent().getAddress().getState());
        contractDetailsResponseDto.setStudentSickness(contract.getStudent().getHealthCondition().getSickness());
        contractDetailsResponseDto.setStudentAllergies(contract.getStudent().getHealthCondition().getAllergies());
        contractDetailsResponseDto.setStudentMedicines(contract.getStudent().getHealthCondition().getMedicines());
        contractDetailsResponseDto.setStudentHealthRemarks(contract.getStudent().getHealthCondition().getRemarks());
        contractDetailsResponseDto.setSchoolName(contract.getStudent().getSchedule().getSchool().getName());
        contractDetailsResponseDto.setSchoolZipCode(contract.getStudent().getSchedule().getSchool().getAddress().getZipCode());
        contractDetailsResponseDto.setSchoolStreet(contract.getStudent().getSchedule().getSchool().getAddress().getStreet());
        contractDetailsResponseDto.setSchoolNumber(contract.getStudent().getSchedule().getSchool().getAddress().getNumber());
        contractDetailsResponseDto.setSchoolDistrict(contract.getStudent().getSchedule().getSchool().getAddress().getDistrict());
        contractDetailsResponseDto.setSchoolCity(contract.getStudent().getSchedule().getSchool().getAddress().getCity());
        contractDetailsResponseDto.setSchoolState(contract.getStudent().getSchedule().getSchool().getAddress().getState());
        contractDetailsResponseDto.setEntryTime(contract.getStudent().getSchedule().getEntry());
        contractDetailsResponseDto.setDepartureTime(contract.getStudent().getSchedule().getDeparture());
        contractDetailsResponseDto.setResponsibleName(contract.getStudent().getResponsible().getName());
        contractDetailsResponseDto.setResponsibleRg(contract.getStudent().getResponsible().getRg());
        contractDetailsResponseDto.setResponsibleCpf(contract.getStudent().getResponsible().getCpf());
        contractDetailsResponseDto.setResponsibleDateOfBirth(contract.getStudent().getResponsible().getDateOfBirth());
        contractDetailsResponseDto.setResponsibleRelationship(contract.getStudent().getResponsible().getRelationship());
        contractDetailsResponseDto.setResponsibleMainContact(contract.getStudent().getResponsible().getMainContact());
        contractDetailsResponseDto.setResponsibleSecondaryContact(contract.getStudent().getResponsible().getSecondaryContact());
        contractDetailsResponseDto.setResponsibleEmail(contract.getStudent().getResponsible().getEmail());
        contractDetailsResponseDto.setResponsibleEmergencyContact(contract.getStudent().getResponsible().getEmergencyContact());
        contractDetailsResponseDto.setResponsibleRemarks(contract.getStudent().getResponsible().getRemarks());
        contractDetailsResponseDto.setAmount(contract.getAmount());
        contractDetailsResponseDto.setFirstParcel(contract.getFirstParcel());
        contractDetailsResponseDto.setCollectionDay(contract.getCollectionDay());
        contractDetailsResponseDto.setNumberOfParcels(contract.getNumberOfParcels());
        contractDetailsResponseDto.setParcelValue(contract.getParcelValue());
        contractDetailsResponseDto.setYear(contract.getYear());
        contractDetailsResponseDto.setStatus(contract.getStatus());
        return contractDetailsResponseDto;
    }

}
