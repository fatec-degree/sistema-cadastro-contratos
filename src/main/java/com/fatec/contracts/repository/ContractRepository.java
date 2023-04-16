package com.fatec.contracts.repository;

import com.fatec.contracts.model.Contract;
import com.fatec.contracts.repository.projections.ContractProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = "SELECT contr.id, stud.name as studentName, resp.name as responsibleName, schoo.name as schoolName, contr.start, contr.end, contr.amount, contr.year, contr.status FROM contracts contr " +
                   "INNER JOIN responsibles resp on contr.responsible_id = resp.id " +
                   "INNER JOIN students stud on contr.student_id = stud.id " +
                   "INNER JOIN schedules sched on stud.schedule_id = sched.id " +
                   "INNER JOIN schools schoo on sched.school_id = schoo.id", nativeQuery = true)
    List<ContractProjection> findAllContractsForHome();

}
