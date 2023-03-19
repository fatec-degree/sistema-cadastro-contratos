package com.fatec.contracts.repository;

import com.fatec.contracts.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
