package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.MultiFactorModelOfAltman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MultiFactorModelOfAltmanRepository extends JpaRepository<MultiFactorModelOfAltman, Long> {
    List<MultiFactorModelOfAltman> findAllByCompany(Company company);
    List<MultiFactorModelOfAltman> findAll();
}
