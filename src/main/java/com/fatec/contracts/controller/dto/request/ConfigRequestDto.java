package com.fatec.contracts.controller.dto.request;

import com.fatec.contracts.model.Address;
import com.fatec.contracts.model.Person;
import com.fatec.contracts.model.ServiceProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class ConfigRequestDto {

    private Long id;
    private String cnpj;
    private String corporateName;
    private Long representativeId;
    private String representativeName;
    private String representativeRg;
    private String representativeCpf;
    private LocalDate representativeDateOfBirth;
    private String representativeMainContact;
    private String representativeSecondaryContact;
    private String representativeEmail;
    private Long representativeAddressId;
    private String representativeZipCode;
    private String representativeStreet;
    private String representativeDistrict;
    private String representativeCity;
    private String representativeHouseNumber;
    private String representativeState;

    public ServiceProvider toServiceProvider() {
        Address address = new Address();
        if(this.representativeAddressId != null) address.setId(this.representativeAddressId);
        address.setZipCode(this.representativeZipCode);
        address.setNumber(this.representativeHouseNumber);
        address.setStreet(this.representativeStreet);
        address.setDistrict(this.representativeDistrict);
        address.setCity(this.representativeCity);
        address.setState(this.representativeState);

        Person representative = new Person();
        if(this.representativeId != null) representative.setId(this.representativeId);
        representative.setName(this.representativeName);
        representative.setRg(this.representativeRg);
        representative.setCpf(this.representativeCpf);
        representative.setDateOfBirth(this.representativeDateOfBirth);
        representative.setMainContact(this.representativeMainContact);
        representative.setSecondaryContact(this.representativeSecondaryContact);
        representative.setEmail(this.representativeEmail);
        representative.setAddress(address);

        ServiceProvider serviceProvider = new ServiceProvider();
        if(this.id != null) serviceProvider.setId(this.id);
        serviceProvider.setCnpj(this.cnpj);
        serviceProvider.setCorporateName(this.corporateName);
        serviceProvider.setRepresentative(representative);
        return serviceProvider;
    }

    public ConfigRequestDto(ServiceProvider serviceProvider) {
        this.id = serviceProvider.getId();
        this.cnpj = serviceProvider.getCnpj();
        this.corporateName = serviceProvider.getCorporateName();
        this.representativeId = serviceProvider.getRepresentative().getId();
        this.representativeName = serviceProvider.getRepresentative().getName();
        this.representativeRg = serviceProvider.getRepresentative().getRg();
        this.representativeCpf = serviceProvider.getRepresentative().getCpf();
        this.representativeDateOfBirth = serviceProvider.getRepresentative().getDateOfBirth();
        this.representativeMainContact = serviceProvider.getRepresentative().getMainContact();
        this.representativeSecondaryContact = serviceProvider.getRepresentative().getSecondaryContact();
        this.representativeEmail = serviceProvider.getRepresentative().getEmail();
        this.representativeAddressId = serviceProvider.getRepresentative().getAddress().getId();
        this.representativeZipCode = serviceProvider.getRepresentative().getAddress().getZipCode();
        this.representativeStreet = serviceProvider.getRepresentative().getAddress().getStreet();
        this.representativeDistrict = serviceProvider.getRepresentative().getAddress().getDistrict();
        this.representativeCity = serviceProvider.getRepresentative().getAddress().getCity();
        this.representativeHouseNumber = serviceProvider.getRepresentative().getAddress().getNumber();
        this.representativeState = serviceProvider.getRepresentative().getAddress().getState();
    }

}
