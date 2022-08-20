package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CompanyService implements ICompanyService {
    private final CompanyRepository companyRepository;
    private final IUserService userService;
    private final IDepartmentService departmentService;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, IUserService userService, IDepartmentService departmentService){
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.departmentService = departmentService;
    }


    @Override
    public Company addCompany(Company company) {
        if (isNull(company)) {
            throw new EntityNotFoundException("Company is empty");
        }
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new EntityNotFoundException("Company not found"));
    }

    @Override
    public Company updateCompany(Company company) {
        if (isNull(company)) {
            throw new EntityNotFoundException("Requested update is empty");
        }
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long companyId) {
        Company company = this.getCompanyById(companyId);
        departmentService.deleteDepartmentsByCompany(company);
        companyRepository.delete(company);
    }

    @Override
    public List<Company> getAllCompany() {
        List<Company> allCompanies = companyRepository.findAll();
        if (allCompanies.isEmpty())
            throw new EntityNotFoundException("No companies found in DB");
        return allCompanies;
    }

    @Override
    public Company getCompanyByIpn(Integer ipn) {
        Company companyByIpn = companyRepository.findCompanyByIpn(ipn);
        if (isNull(companyByIpn)) {
            throw new EntityNotFoundException("This company doesn't exist");
        }
        return companyByIpn;
    }

    @Override
    public Company getCompanyByEdrpou(Integer ipn) {
        Company companyByEdrpou = companyRepository.findCompanyByEdrpou(ipn);
        if (isNull(companyByEdrpou)) {
            throw new EntityNotFoundException("This company doesn't exist");
        }
        return companyByEdrpou;
    }

    @Override
    public List<Company> getCompanyByName(String name) {
        List<Company> companiesByName = companyRepository.findCompanyByCompanyNameLike(name);
        if (companiesByName.isEmpty()) {
            throw new EntityNotFoundException("This companies doesn't exist");
        }
        return companiesByName;
    }

    @Override
    public List<Company> getCompaniesThatNotConfirm(){
        return companyRepository.findAllByConfirmationFalse();
    }

    @Override
    public void confirmCompany(Long companyId){
        Company company = this.getCompanyById(companyId);
        if(isNull(company)){
            throw new EntityNotFoundException("This company doesn't exist");
        }
        company.setConfirmation(true);
        companyRepository.save(company);
    }

    @Override
    public List<Company> getOwnersCompanies(Long userId){
        return companyRepository.findAllByHeadOfCompany(userService.getUser(userId));
    }

    public List<Department> getAllCompanyDepartments(Long companyId){
        Company company = this.getCompanyById(companyId);
        return departmentService.allDepartmentForCompany(company);
    }
}
