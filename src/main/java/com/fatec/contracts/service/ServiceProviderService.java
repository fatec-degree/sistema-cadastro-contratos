package com.fatec.contracts.service;

import com.fatec.contracts.model.Address;
import com.fatec.contracts.model.Person;
import com.fatec.contracts.model.ServiceProvider;
import com.fatec.contracts.repository.AddressRepository;
import com.fatec.contracts.repository.PersonRepository;
import com.fatec.contracts.repository.ServiceProviderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServiceProviderService {

    private ServiceProviderRepository serviceProviderRepository;
    private PersonService personService;
    private AddressService addressService;
    private ModelMapper modelMapper;

    public ServiceProvider findById(Long id) {
        return serviceProviderRepository.findById(id).orElseThrow(() -> new RuntimeException("Provedor de Serviço não encontrado."));
    }

    @Transactional
    public ServiceProvider save(ServiceProvider serviceProvider) {
        Address address = addressService.save(serviceProvider.getRepresentative().getAddress());
        serviceProvider.getRepresentative().setAddress(address);
        Person representative = personService.save(serviceProvider.getRepresentative());
        serviceProvider.setRepresentative(representative);
        return this.serviceProviderRepository.save(serviceProvider);
    }

    @Transactional
    public ServiceProvider update(ServiceProvider serviceProvider) {
        if(serviceProvider.getId() != null){
            ServiceProvider serviceProviderToUpdate = findById(serviceProvider.getId());
            modelMapper.map(serviceProvider, serviceProviderToUpdate);
            return serviceProviderRepository.save(serviceProviderToUpdate);
        }
        return save(serviceProvider);
    }

}
