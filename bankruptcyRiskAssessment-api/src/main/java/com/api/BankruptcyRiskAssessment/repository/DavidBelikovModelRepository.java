package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.DavidBelikovModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DavidBelikovModelRepository extends JpaRepository<DavidBelikovModel, Long> {
    List<DavidBelikovModel> findAllByCompany(Company company);
    List<DavidBelikovModel> findAll();
}
