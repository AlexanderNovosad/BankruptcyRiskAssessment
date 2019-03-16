package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyByCompanyName (String name);
    Company findCompanyByEdrpou (Integer edrpou);
    List <Company> findAllByIpn (Integer ipn);
    List <Company> findAll (Sort sort);
}
