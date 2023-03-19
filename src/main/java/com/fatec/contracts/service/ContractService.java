package com.fatec.contracts.service;

import com.fatec.contracts.controller.dto.ContractDto;
import com.fatec.contracts.model.*;
import com.fatec.contracts.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class ContractService {

    private ContractRepository contractRepository;
    private ServiceProviderRepository serviceProviderRepository;
    private AddressRepository addressRepository;
    private HealthConditionRepository healthConditionRepository;
    private ResponsibleRepository responsibleRepository;
    private ScheduleRepository scheduleRepository;
    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;

    @Transactional
    public Contract save(ContractDto contractDto) {
        Address studentAddress = new Address();
        studentAddress.setZipCode(contractDto.getStudentZipCode());
        studentAddress.setNumber(contractDto.getStudentHouseNumber());
        studentAddress.setStreet(contractDto.getStudentStreet());
        studentAddress.setDistrict(contractDto.getStudentDistrict());
        studentAddress.setCity(contractDto.getStudentCity());
        studentAddress = addressRepository.save(studentAddress);

        HealthCondition healthCondition = new HealthCondition();
        healthCondition.setSickness(contractDto.getStudentSickness());
        healthCondition.setAllergies(contractDto.getStudentAllergies());
        healthCondition.setMedicines(contractDto.getStudentMedicines());
        healthCondition.setRemarks(contractDto.getStudentHealthRemarks());

        Address schoolAddress = new Address();
        schoolAddress.setZipCode(contractDto.getSchoolZipCode());
        schoolAddress.setNumber(contractDto.getSchoolNumber());
        schoolAddress.setStreet(contractDto.getSchoolStreet());
        schoolAddress.setDistrict(contractDto.getSchoolDistrict());
        schoolAddress.setCity(contractDto.getSchoolCity());

        School school = new School();
        school.setName(contractDto.getSchoolName());
        school.setAddress(addressRepository.save(schoolAddress));

        Schedule schedule = new Schedule();
        schedule.setEntry(contractDto.getEntryTime());
        schedule.setDeparture(contractDto.getDepartureTime());
        schedule.setSchool(schoolRepository.save(school));

        Responsible responsible = new Responsible();
        responsible.setName(contractDto.getResponsibleName());
        responsible.setRg(contractDto.getResponsibleRg());
        responsible.setCpf(contractDto.getResponsibleCpf());
        responsible.setDateOfBirth(contractDto.getResponsibleDateOfBirth());
        responsible.setAddress(studentAddress);
        responsible.setMainContact(contractDto.getResponsibleMainContact());
        responsible.setSecondaryContact(contractDto.getResponsibleSecondaryContact());
        responsible.setEmail(contractDto.getResponsibleEmail());
        responsible.setRemarks(contractDto.getResponsibleRemarks());
        responsible = responsibleRepository.save(responsible);

        Student student = new Student();
        student.setName(contractDto.getStudentName());
        student.setRg(contractDto.getStudentRg());
        student.setCpf(contractDto.getStudentCpf());
        student.setDateOfBirth(contractDto.getStudentDateOfBirth());
        student.setAddress(studentAddress);
        student.setHealthCondition(healthConditionRepository.save(healthCondition));
        student.setSchedule(scheduleRepository.save(schedule));
        student.setResponsible(responsible);
        studentRepository.save(student);

        Contract contract = new Contract();
        contract.setAmount(contractDto.getAmount());
        contract.setYear(contractDto.getYear());
        contract.setStart(LocalDate.now());
        contract.setEnd(contract.getStart().plusMonths(12));
        contract.setResponsible(responsible);
        ServiceProvider serviceProvider = serviceProviderRepository.findById(1L).get();
        contract.setServiceProvider(serviceProvider);

        return contractRepository.save(contract);
    }

}
