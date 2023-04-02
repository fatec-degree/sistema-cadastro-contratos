package com.fatec.contracts.controller.dto.request;

import com.fatec.contracts.model.Address;
import com.fatec.contracts.model.Person;
import com.fatec.contracts.model.ServiceProvider;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
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

    public ServiceProvider toServiceProvider() {
        Address address = new Address();
        address.setZipCode(this.representativeZipCode);
        address.setNumber(this.representativeHouseNumber);
        address.setStreet(this.representativeStreet);
        address.setDistrict(this.representativeDistrict);
        address.setCity(this.representativeCity);
        address.setState(this.representativeState);

        Person representative = new Person();
        representative.setName(this.representativeName);
        representative.setRg(this.representativeRg);
        representative.setCpf(this.representativeCpf);
        representative.setDateOfBirth(this.representativeDateOfBirth);
        representative.setMainContact(this.representativeMainContact);
        representative.setSecondaryContact(this.representativeSecondaryContact);
        representative.setEmail(this.representativeEmail);
        representative.setAddress(address);

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setCnpj(this.cnpj);
        serviceProvider.setCorporateName(this.corporateName);
        serviceProvider.setRepresentative(representative);
        return serviceProvider;
    }

}
