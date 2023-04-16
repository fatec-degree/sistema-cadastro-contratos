package com.fatec.contracts.repository.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ContractProjection {

    Long getId();
    String getStudentName();
    String getResponsibleName();
    String getSchoolName();
    LocalDate getStart();
    LocalDate getEnd();
    BigDecimal getAmount();
    Integer getYear();
    String getStatus();

}
