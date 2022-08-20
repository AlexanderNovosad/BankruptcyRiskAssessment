package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final ICompanyService companyService;

    @Autowired
    public CompanyController(ICompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping(value = "/company")
    public ResponseEntity<Company> addCompany(@Valid @RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addCompany(company));
    }

    @DeleteMapping(value = "/company")
    public ResponseEntity deleteCompany(@RequestParam(value = "companyId") Long companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity.status(HttpStatus.OK).body("delete completed successfully");
    }

    @GetMapping(value = "/company")
    public ResponseEntity<Company> getCompanyById(@RequestParam(value = "companyId") Long companyId) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyById(companyId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAllCompany());
    }

    @PutMapping(value = "/company")
    public ResponseEntity<Company> updateCompany(@Valid @RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateCompany(company));
    }

    @GetMapping(value = "/confirm")
    public ResponseEntity<List<Company>> getCompaniesThatNotConfirmation(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompaniesThatNotConfirm());
    }

    @PutMapping(value = "/confirm")
    public ResponseEntity confirmCompany(@RequestBody Long companyId){
        companyService.confirmCompany(companyId);
        return ResponseEntity.status(HttpStatus.OK).body("Company confirmed");
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<Company>> getOwnersCompanies(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getOwnersCompanies(userId));
    }

}
