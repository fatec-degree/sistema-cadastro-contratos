package com.fatec.contracts.repository;

import com.fatec.contracts.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
