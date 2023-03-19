package com.fatec.contracts.repository;

import com.fatec.contracts.model.HealthCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthConditionRepository extends JpaRepository<HealthCondition, Long> {
}
