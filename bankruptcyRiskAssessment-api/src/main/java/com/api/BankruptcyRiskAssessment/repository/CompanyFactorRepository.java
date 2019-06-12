package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.CompanyFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface CompanyFactorRepository extends JpaRepository<CompanyFactor, Long> {
    ArrayList<CompanyFactor> findAllByCompany(Company company);
    ArrayList<CompanyFactor> findAll();
}
