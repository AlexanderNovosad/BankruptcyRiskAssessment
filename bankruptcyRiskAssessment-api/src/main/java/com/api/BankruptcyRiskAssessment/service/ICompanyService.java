package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;

import java.util.List;

public interface ICompanyService {

    Company addCompany(Company company);

    Company getCompanyById(Long companyId);

    Company updateCompany(Company company);

    void deleteCompany(Long companyId);

    List<Company> getAllCompany();

    Company getCompanyByIpn(Integer ipn);

    Company getCompanyByEdrpou(Integer ipn);

    List<Company> getCompanyByName(String name);

    List<Company> getCompaniesThatNotConfirm();

    void confirmCompany(Long companyId);

    List<Company> getOwnersCompanies(Long userId);

    List<Department> getAllCompanyDepartments(Long companyId);

}
