package com.fatec.contracts.service;

import com.fatec.contracts.model.Address;
import com.fatec.contracts.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {

    private AddressRepository addressRepository;

    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

}
