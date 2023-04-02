package com.fatec.contracts.service;

import com.fatec.contracts.model.Address;
import com.fatec.contracts.model.Person;
import com.fatec.contracts.model.ServiceProvider;
import com.fatec.contracts.repository.AddressRepository;
import com.fatec.contracts.repository.PersonRepository;
import com.fatec.contracts.repository.ServiceProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServiceProviderService {

    private ServiceProviderRepository serviceProviderRepository;
    private PersonRepository personRepository;
    private AddressRepository addressRepository;

    public ServiceProvider save(ServiceProvider serviceProvider) {
        Address address = addressRepository.save(serviceProvider.getRepresentative().getAddress());
        serviceProvider.getRepresentative().setAddress(address);
        Person representative = personRepository.save(serviceProvider.getRepresentative());
        serviceProvider.setRepresentative(representative);
        return this.serviceProviderRepository.save(serviceProvider);
    }

}
