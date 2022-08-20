package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.*;
import com.api.BankruptcyRiskAssessment.entity.unit.*;
import com.api.BankruptcyRiskAssessment.service.IBankruptcyService;
import com.api.BankruptcyRiskAssessment.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bankruptcy")
public class BankruptcyController {
    private final IBankruptcyService bankruptcyService;
    private final ICompanyService companyService;

    @Autowired
    public BankruptcyController(IBankruptcyService bankruptcyService, ICompanyService companyService){
        this.bankruptcyService = bankruptcyService;
        this.companyService = companyService;
    }

    @PostMapping("/indicatorsAssessments")
    public ResponseEntity<List<Indicator>> setTheAssessments(@RequestBody InDataForSetTheAssessments inDataForSetTheAssessments){
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.setThePointsForIndicators(inDataForSetTheAssessments));
    }

    @PostMapping("/nedosekinModel")
    public ResponseEntity<List<Factor>> calculateBankruptcyPoints(@RequestParam(value = "companyId") Long companyId, @RequestBody InDataForCalculationBankruptcyPoints inDataForCalculationBankruptcyPoints){
        Company company = companyService.getCompanyById(companyId);
        ArrayList<Factor> factors = new ArrayList<>(bankruptcyService.calculateFactorsPoints(company, inDataForCalculationBankruptcyPoints.getIndicators(), inDataForCalculationBankruptcyPoints.getDependencies()));
        factors.add(bankruptcyService.calculateCompanyPoints(company, factors, inDataForCalculationBankruptcyPoints.getFactorsDependencies()));
        return ResponseEntity.status(HttpStatus.OK).body(factors);
    }

    @GetMapping("/factors")
    public ResponseEntity<List<Factor>> getFactors(){
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getFactors());
    }

    @GetMapping("/indicators/QualitativeIndicators")
    public ResponseEntity<List<Indicator>> getQualitativeIndicators(){
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getQualitativeIndicators());
    }

    @GetMapping("/indicators/QuantitativeIndicators")
    public ResponseEntity<List<QuantitativeIndicator>> getQuantitativeIndicators(){
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getQuantitativeIndicators());
    }

    @PostMapping("/indicators/QuantitativeIndicators/PreQuantitativeIndicators")
    public ResponseEntity<List<PreQuantitativeIndicator>> getPreQuantitativeIndicators(@RequestBody List<QuantitativeIndicator> quantitativeIndicators){
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getPreQuantitativeIndicators(quantitativeIndicators));
    }

    @PostMapping("/indicators/QuantitativeIndicators")
    public ResponseEntity<List<QuantitativeIndicator>> calculateAmountOfQuantitativeIndicators(@RequestBody InDataForCalculationQuantitativeIndicatorAmount inDataForCalculationQuantitativeIndicatorAmount){
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.calculateAmountOfQuantitativeIndicators(inDataForCalculationQuantitativeIndicatorAmount));
    }

    @PostMapping(value = "multiFactorModelOfAltman")
    public ResponseEntity<MultiFactorModelOfAltman> multiFactorModelOfAltmanCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody MultiFactorModelOfAltmanData multiFactorModelOfAltmanData){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.multiFactorModelOfAltmanResult(company, multiFactorModelOfAltmanData));
    }

    @PostMapping(value = "lissModel")
    public ResponseEntity<LissModel> lissModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody LissModelData lissModelData){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.lissModelResult(company, lissModelData));
    }

    @PostMapping(value = "davidBelikovModel")
    public ResponseEntity<DavidBelikovModel> davidBelikovModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody DavidBelikovModelData davidBelikovModelData){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.davidBelikovModelResult(company, davidBelikovModelData));
    }

    @PostMapping(value = "springateModel")
    public ResponseEntity<SpringateModel> springateModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody SpringateModelData springateModelData){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.springateModelResult(company, springateModelData));
    }

    @PostMapping(value = "universalDiscriminatoryModel")
    public ResponseEntity<UniversalDiscriminatoryModel> universalDiscriminatoryModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody UniversalDiscriminatoryModelData universalDiscriminatoryModelData){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.universalDiscriminatoryModelResult(company, universalDiscriminatoryModelData));
    }

    @GetMapping(value = "nedosekinModelIndicators")
    public ResponseEntity<List<CompanyFactor>> getNedosekinModelIndicatorsForCompany(@RequestParam(value = "companyId") Long companyId){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getNedosekinModelIndicatorsForCompany(company));
    }

    @GetMapping(value = "lissModelIndicators")
    public ResponseEntity<List<LissModel>> getLissModelIndicatorsForCompany(@RequestParam(value = "companyId") Long companyId){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getLissModelIndicatorsForCompany(company));
    }

    @GetMapping(value = "davidBelikovModelIndicators")
    public ResponseEntity<List<DavidBelikovModel>> getDavidBelikovModelIndicatorsForCompany(@RequestParam(value = "companyId") Long companyId){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getDavidBelikovModelIndicatorsForCompany(company));
    }

    @GetMapping(value = "multiFactorModelOfAltmanIndicators")
    public ResponseEntity<List<MultiFactorModelOfAltman>> getMultiFactorModelOfAltmanIndicatorsForCompany(@RequestParam(value = "companyId") Long companyId){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getMultiFactorModelOfAltmanIndicatorsForCompany(company));
    }

    @GetMapping(value = "springateModelIndicators")
    public ResponseEntity<List<SpringateModel>> getSpringateModelIndicatorsForCompany(@RequestParam(value = "companyId") Long companyId){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getSpringateModelIndicatorsForCompany(company));
    }

    @GetMapping(value = "universalDiscriminatoryModelIndicators")
    public ResponseEntity<List<UniversalDiscriminatoryModel>> getUniversalDiscriminatoryModelIndicatorsForCompany(@RequestParam(value = "companyId") Long companyId){
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(bankruptcyService.getUniversalDiscriminatoryModelIndicatorsForCompany(company));
    }

}
