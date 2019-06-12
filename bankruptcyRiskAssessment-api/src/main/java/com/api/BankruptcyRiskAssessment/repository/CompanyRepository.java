package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findCompanyByCompanyNameLike(String name);

    Company findCompanyByEdrpou(Integer edrpou);

    Company findCompanyByIpn(Integer ipn);

    List<Company> findAllByHeadOfCompany(User headOfDepartment);

    List<Company> findAll(Sort sort);
}
