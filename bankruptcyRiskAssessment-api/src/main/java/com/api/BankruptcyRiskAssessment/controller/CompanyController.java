package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

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

    @PutMapping(value = "/company")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        if (isNull(company)) {
            return ResponseEntity.notFound().build();
        }
        Company updatedCompany = companyService.updateCompany(company);
        return ResponseEntity.ok(updatedCompany);
    }

}
