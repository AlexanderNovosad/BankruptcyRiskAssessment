package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findCompanyByCompanyNameLike(String name);

    Company findCompanyByEdrpou(Integer edrpou);

    Company findCompanyByIpn(Integer ipn);

    List<Company> findAll(Sort sort);
}
