package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.service.ICompanyService;
import com.api.BankruptcyRiskAssessment.service.IExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    public ICompanyService companyService;
    @Autowired
    public IExpertService expertService;

    @PostMapping(value = "/company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        if (isNull(company)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @DeleteMapping(value = "/company")
    public ResponseEntity<Company> deleteCompany(@RequestParam(value = "companyId") Long companyId) {
        Company company = companyService.deleteCompany(companyId);
        if (isNull(company)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(company);
    }

    @GetMapping(value = "/company")
    public ResponseEntity<Company> getCompanyById(@RequestParam(value = "companyId") Long companyId) {
        Company companyById = companyService.getCompanyById(companyId);
        if (isNull(companyById)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyById);
    }

    @GetMapping(value = "/company/expert")
    public ResponseEntity<List<ExpertAccess>> getCompanyByExpert(@RequestParam(value = "userId") Long userId) {
        List<ExpertAccess> companies = expertService.getCompaniesByExpert(userId);
        if (isNull(companies)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companies);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(companyService.getAllCompany());
    }

    @PutMapping(value = "/company")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        if (isNull(company)) {
            return ResponseEntity.notFound().build();
        }
        Company updatedCompany = companyService.updateCompany(company);
        return ResponseEntity.ok(updatedCompany);
    }

    @GetMapping(value = "/confirm")
    public ResponseEntity<List<Company>> getCompaniesThatNotConfirmation(){
        return ResponseEntity.ok(companyService.getCompaniesThatNotConfirmation());
    }

    @PostMapping(value = "/confirm")
    public ResponseEntity<Company> confirmCompany(@RequestParam(value = "companyId") Long companyId ){
        Company company = companyService.getCompanyById(companyId);
        if(isNull(company)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyService.confirmCompany(company));
    }

}
