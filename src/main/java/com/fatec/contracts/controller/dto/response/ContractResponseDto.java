package com.fatec.contracts.controller.dto.response;

import com.fatec.contracts.repository.projections.ContractProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ContractResponseDto {

    private Long id;
    private String studentName;
    private String responsibleName;
    private String schoolName;
    private LocalDate startContract;
    private LocalDate endContract;
    private BigDecimal amount;
    private Integer year;
    private String status;

    public ContractResponseDto(ContractProjection contractProjection) {
        this.id = contractProjection.getId();
        this.studentName = contractProjection.getStudentName();
        this.schoolName = contractProjection.getSchoolName();
        this.responsibleName = contractProjection.getResponsibleName();
        this.startContract = contractProjection.getStart();
        this.endContract = contractProjection.getEnd();
        this.amount = contractProjection.getAmount();
        this.year = contractProjection.getYear();
        this.status = contractProjection.getStatus();
    }

    public static List<ContractResponseDto> toContractResponseDto(List<ContractProjection> contractProjections) {
        return contractProjections
                .stream()
                .map(ContractResponseDto::new)
                .toList();
    }

}
