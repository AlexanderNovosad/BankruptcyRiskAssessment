package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;

import java.util.List;

public interface ICompanyService {

    Company addCompany(Company company);

    Company getCompanyById(Long companyId);

    List<ExpertAccess> getCompaniesByExpert(Long userId);

    Company updateCompany(Company company);

    Company deleteCompany(Long companyId);

    List<Company> getAllCompany();

    Company getCompanyByIpn(Integer ipn);

    Company getCompanyByEdrpou(Integer ipn);

    List<Company> getCompanyByName(String name);
}
