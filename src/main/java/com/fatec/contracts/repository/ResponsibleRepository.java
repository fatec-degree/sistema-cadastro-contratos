package com.fatec.contracts.repository;

import com.fatec.contracts.model.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
}
