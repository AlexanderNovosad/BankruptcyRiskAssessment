package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.UniversalDiscriminatoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UniversalDiscriminatoryModelRepository extends JpaRepository<UniversalDiscriminatoryModel, Long> {
    List<UniversalDiscriminatoryModel> findAllByCompany(Company company);
    List<UniversalDiscriminatoryModel> findAll();
}
