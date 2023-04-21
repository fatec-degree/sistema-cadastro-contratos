package com.fatec.contracts.service;

import com.fatec.contracts.controller.dto.request.ContractDto;
import com.fatec.contracts.model.*;
import com.fatec.contracts.repository.*;
import com.fatec.contracts.repository.projections.ContractProjection;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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
    private PDFGenerator pdfGenerator;
    private SignatureService signatureService;
    private MessageSource messageSource;

    @Transactional
    public Contract save(ContractDto contractDto) {
        Address studentAddress = new Address();
        studentAddress.setZipCode(contractDto.getStudentZipCode());
        studentAddress.setNumber(contractDto.getStudentHouseNumber());
        studentAddress.setStreet(contractDto.getStudentStreet());
        studentAddress.setDistrict(contractDto.getStudentDistrict());
        studentAddress.setCity(contractDto.getStudentCity());
        studentAddress.setState(contractDto.getStudentState());
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
        schoolAddress.setState(contractDto.getSchoolState());

        School school = new School();
        school.setName(contractDto.getSchoolName());
        school.setAddress(addressRepository.save(schoolAddress));

        Schedule schedule = new Schedule();
        schedule.setEntry(contractDto.getEntryTime());
        schedule.setDeparture(contractDto.getDepartureTime());
        schedule.setSchool(schoolRepository.save(school));

        Responsible responsible = new Responsible();
        responsible.setName(contractDto.getResponsibleName());
        responsible.setRelationship(contractDto.getResponsibleRelationship());
        responsible.setRg(contractDto.getResponsibleRg());
        responsible.setCpf(contractDto.getResponsibleCpf());
        responsible.setDateOfBirth(contractDto.getResponsibleDateOfBirth());
        responsible.setAddress(studentAddress);
        responsible.setMainContact(contractDto.getResponsibleMainContact());
        responsible.setSecondaryContact(contractDto.getResponsibleSecondaryContact());
        responsible.setEmail(contractDto.getResponsibleEmail());
        responsible.setEmergencyContact(contractDto.getResponsibleEmergencyContact());
        responsible.setRelationship(contractDto.getResponsibleRelationship());
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
        student = studentRepository.save(student);

        Contract contract = new Contract();
        contract.setAmount(contractDto.getAmount());
        contract.setFirstParcel(contractDto.getFirstParcel());
        contract.setCollectionDay(contractDto.getCollectionDay());
        contract.setNumberOfParcels(contractDto.getNumberOfParcels());
        contract.setParcelValue(contractDto.getParcelValue());
        contract.setYear(contractDto.getYear());
        contract.setStart(LocalDate.now());
        contract.setEnd(contract.getStart().plusMonths(12));
        contract.setResponsible(responsible);
        contract.setStudent(student);
        ServiceProvider serviceProvider = serviceProviderRepository.findById(1L).get();
        contract.setServiceProvider(serviceProvider);
        byte[] file = savePDFFile(serviceProvider, student, schedule, contract);
        String documentName = "contrato-prestacao-servico-" + responsible.getName() + "-" + responsible.getCpf();
        String uuid = signatureService.execute(Arrays.asList(responsible.getEmail(), serviceProvider.getRepresentative().getEmail()),
                                               file,
                                               documentName,
                                               messageSource.getMessage("messageToSigner", null, Locale.getDefault()));
        contract.setUuid(uuid);
        contract.setFileData(file);
        return contractRepository.save(contract);
    }

    public List<ContractProjection> findAll() {
        return contractRepository.findAllContractsForHome();
    }

    private byte[] savePDFFile(ServiceProvider serviceProvider, Student student, Schedule schedule, Contract contract) {
        pdfGenerator.loadDocument();
        Map<String, String> fieldValues = new HashMap<>();
        fieldValues.put("Text2", serviceProvider.getCnpj());
        fieldValues.put("Text3", serviceProvider.getCorporateName());
        fieldValues.put("Text4", serviceProvider.getRepresentative().getName());
        fieldValues.put("Text5", serviceProvider.getRepresentative().getRg());
        fieldValues.put("Text6", serviceProvider.getRepresentative().getCpf());
        fieldValues.put("Text8", serviceProvider.getRepresentative().getAddress().getCompleteAddress());
        fieldValues.put("Text9", serviceProvider.getRepresentative().getContacts());
        fieldValues.put("Text10", student.getName());
        fieldValues.put("Text11", student.getDateOfBirth().toString());
        fieldValues.put("Text12", student.getResponsible().getName());
        fieldValues.put("Text13", student.getResponsible().getRg());
        fieldValues.put("Text15", student.getResponsible().getCpf());
        fieldValues.put("Text16", student.getResponsible().getRelationship());
        fieldValues.put("Text17", student.getAddress().getStreet());
        fieldValues.put("Text18", student.getAddress().getNumber());
        fieldValues.put("Text19", student.getAddress().getDistrict());
        fieldValues.put("Text20", student.getAddress().getCity());
        fieldValues.put("Text21", student.getAddress().getState());
        fieldValues.put("Text22", student.getAddress().getZipCode());
        fieldValues.put("Text23", student.getResponsible().getContacts());
        fieldValues.put("Text26", student.getHealthCondition().getSickness());
        fieldValues.put("Text28", student.getHealthCondition().getMedicines());
        fieldValues.put("Text30", student.getHealthCondition().getAllergies());
        fieldValues.put("Text31", schedule.getSchool().getName());
        fieldValues.put("Text32", schedule.getEntry().toString());
        fieldValues.put("Text33", schedule.getDeparture().toString());
        fieldValues.put("Text34", contract.getYear().toString());
        fieldValues.put("Text35", contract.getYear().toString());
        fieldValues.put("Text36", contract.getAmount().toString());
        fieldValues.put("Text37", contract.getNumberOfParcels().toString());
        fieldValues.put("Text38", contract.getFirstParcel().toString());
        fieldValues.put("Text39", contract.getCollectionDay().toString());
        fieldValues.put("Text40", contract.getStart().getDayOfMonth() + "");
        fieldValues.put("Text41", contract.getStart().getMonth().name());
        fieldValues.put("Text42", contract.getStart().getYear() + "");
        fieldValues.put("Text43", student.getName());
        fieldValues.put("Text44", student.getAddress().getStreet());
        fieldValues.put("Text45", student.getAddress().getNumber());
        fieldValues.put("Text46", student.getAddress().getDistrict());
        fieldValues.put("Text47", student.getAddress().getCity());
        fieldValues.put("Text48", student.getAddress().getState());
        fieldValues.put("Text49", student.getAddress().getZipCode());
        fieldValues.put("Text50", schedule.getSchool().getName());
        fieldValues.put("Text51", schedule.getCompletePeriod());
        fieldValues.put("Text52", student.getResponsible().getName());
        fieldValues.put("Text53", student.getResponsible().getContacts());
        fieldValues.put("Text54", student.getResponsible().getEmergencyContact());
        fieldValues.put("Text55", student.getHealthCondition().toString());
        fieldValues.put("Text56", student.getResponsible().getRemarks());
        pdfGenerator.fillFields(fieldValues);
        try {
            return pdfGenerator.saveDocument();
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível gerar o arquivo PDF: " + e);
        } finally {
            pdfGenerator.closeDocument();
        }
    }

    public Contract findById(Long id) {
        return contractRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Contrato não encontrado."));
    }

    @Transactional
    public void updateStatus(String uuid, ContractStatus status) {
        Contract contract = contractRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado."));
        contract.setStatus(status);
        contractRepository.save(contract);
    }

    @Transactional
    public void updateStatus(Long id, ContractStatus status) {
        Contract contract = findById(id);
        contract.setStatus(status);
        contractRepository.save(contract);
    }

    @Transactional
    public void updateFile(Long id, byte[] file) {
        Contract contract = findById(id);
        contract.setFileData(file);
        contractRepository.save(contract);
    }

}
