package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.repository.CompanyRepository;
import com.api.BankruptcyRiskAssessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Company addCompany(Company company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        Company company = companyRepository.getOne(companyId);
        if (company == null) {
            return null;
        }
        return company;
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company deleteCompany(Long companyId) {
        Company company = companyRepository.getOne(companyId);
        if (company == null) {
            return null;
        }
        // add func delete for all users in company (except reg user )
        // add func for delete of all department in company (except dependency of reg user)
        companyRepository.delete(company);
        return company;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyByIpn(Integer ipn) {
        Company companyByIpn = companyRepository.findCompanyByIpn(ipn);
        if (isNull(companyByIpn)) {
            return null;
        }
        return companyByIpn;
    }

    @Override
    public Company getCompanyByEdrpou(Integer ipn) {
        Company companyByEdrpou = companyRepository.findCompanyByEdrpou(ipn);
        if (isNull(companyByEdrpou)) {
            return null;
        }
        return companyByEdrpou;
    }

    @Override
    public List<Company> getCompanyByName(String name) {
        return companyRepository.findCompanyByCompanyNameLike(name);
    }

    @Override
    public List<Company> getCompaniesThatNotConfirm(){
        return companyRepository.findAllByConfirmationFalse();
    }

    @Override
    public void confirmCompany(Company company){
        company.setConfirmation(true);
        companyRepository.save(company);
    }

    @Override
    public List<Company> getOwnersCompanies(Long userId){
        return companyRepository.findAllByHeadOfCompany(userRepository.getOne(userId));
    }
}
