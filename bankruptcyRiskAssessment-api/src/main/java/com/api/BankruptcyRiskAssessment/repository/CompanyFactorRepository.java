package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.CompanyFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CompanyFactorRepository extends JpaRepository<CompanyFactor, Long> {
    List<CompanyFactor> findAllByCompany(Company company);
    List<CompanyFactor> findAll();
}
