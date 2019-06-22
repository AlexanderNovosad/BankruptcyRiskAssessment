package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.*;
import com.api.BankruptcyRiskAssessment.entity.unit.*;
import com.api.BankruptcyRiskAssessment.service.IBankruptcyService;
import com.api.BankruptcyRiskAssessment.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/bankruptcy")
public class BankruptcyController {
    @Autowired
    private IBankruptcyService bankruptcyService;
    @Autowired
    ICompanyService companyService;

    @PostMapping("/indicatorsAssessments")
    public ResponseEntity<List<Indicator>> setTheAssessments(@RequestBody InDataForSetTheAssessments inDataForSetTheAssessments){
        List<Indicator> indicators = inDataForSetTheAssessments.getIndicators();
        List<LinguisticAssessment> assessments = inDataForSetTheAssessments.getAssessments();
        if(isNull(indicators) || isNull(assessments)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankruptcyService.setThePointsForIndicators(indicators, assessments));
    }

    @PostMapping("/nedosekinModel")
    public ResponseEntity<List<Factor>> calculateBankruptcyPoints(@RequestParam(value = "companyId") Long companyId, @RequestBody InDataForCalculationBankruptcyPoints inDataForCalculationBankruptcyPoints){
        ArrayList<Factor> factors = new ArrayList<>();
        List<List<Indicator>> indicators = inDataForCalculationBankruptcyPoints.getIndicators();
        List<List<String>> dependencies = inDataForCalculationBankruptcyPoints.getDependencies();
        List<String> factorsDependencies = inDataForCalculationBankruptcyPoints.getFactorsDependencies();
        Company company = companyService.getCompanyById(companyId);
        if(isNull(indicators) || isNull(dependencies) || isNull(factorsDependencies) || isNull(company)){
            return ResponseEntity.notFound().build();
        }
        for(int i=0; i<indicators.size(); i++){
            factors.add(bankruptcyService.calculateFactorPoints(company, indicators.get(i), dependencies.get(i)));
        }
        factors.add(bankruptcyService.calculateCompanyPoints(company, factors,factorsDependencies));
        return ResponseEntity.ok(factors);
    }

    @GetMapping("/factors")
    public ResponseEntity<List<Factor>> getFactors(){
        List<Factor> factors = bankruptcyService.getFactors();
        return ResponseEntity.ok(factors);
    }

    @GetMapping("/indicators/QualitativeIndicators")
    public ResponseEntity<List<Indicator>> getQualitativeIndicators(){
        List<Indicator> indicators = bankruptcyService.getQualitativeIndicators();
        if (isNull(indicators)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(indicators);
    }

    @GetMapping("/indicators/QuantitativeIndicators")
    public ResponseEntity<List<QuantitativeIndicator>> getQuantitativeIndicators(){
        List<QuantitativeIndicator> indicators = bankruptcyService.getQuantitativeIndicators();
        if (isNull(indicators)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(indicators);
    }

    @PostMapping("/indicators/QuantitativeIndicators/PreQuantitativeIndicators")
    public ResponseEntity<List<PreQuantitativeIndicator>> getPreQuantitativeIndicators(@RequestBody List<QuantitativeIndicator> quantitativeIndicators){
        List<PreQuantitativeIndicator> preQuantitativeIndicators = bankruptcyService.getPreQuantitativeIndicators(quantitativeIndicators);
        if(isNull(preQuantitativeIndicators)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(preQuantitativeIndicators);
    }

    @PostMapping("/indicators/QuantitativeIndicators")
    public ResponseEntity<List<QuantitativeIndicator>> calculateAmountOfQuantitativeIndicators(@RequestBody InDataForCalculationQuantitativeIndicatorAmount inDataForCalculationQuantitativeIndicatorAmount){
        List<QuantitativeIndicator> quantitativeIndicators = inDataForCalculationQuantitativeIndicatorAmount.getQuantitativeIndicators();
        List<PreQuantitativeIndicator> preQuantitativeIndicators = inDataForCalculationQuantitativeIndicatorAmount.getPreQuantitativeIndicators();
        if(isNull(quantitativeIndicators) || isNull(preQuantitativeIndicators)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankruptcyService.calculateAmountOfQuantitativeIndicators(quantitativeIndicators,preQuantitativeIndicators));
    }

    @PostMapping(value = "multiFactorModelOfAltman")
    public ResponseEntity<MultiFactorModelOfAltman> multiFactorModelOfAltmanCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody MultiFactorModelOfAltmanData multiFactorModelOfAltmanData){
        Company company = companyService.getCompanyById(companyId);
        if(isNull(multiFactorModelOfAltmanData) || isNull(company)){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankruptcyService.multiFactorModelOfAltmanResult(company, multiFactorModelOfAltmanData));
    }

    @PostMapping(value = "lissModel")
    public ResponseEntity<LissModel> lissModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody LissModelData lissModelData){
        Company company = companyService.getCompanyById(companyId);
        if(isNull(lissModelData) || isNull(company)){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankruptcyService.lissModelResult(company, lissModelData));
    }

    @PostMapping(value = "davidBelikovModel")
    public ResponseEntity<DavidBelikovModel> davidBelikovModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody DavidBelikovModelData davidBelikovModelData){
        Company company = companyService.getCompanyById(companyId);
        if(isNull(davidBelikovModelData) || isNull(company)){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankruptcyService.davidBelikovModelResult(company, davidBelikovModelData));
    }

    @PostMapping(value = "springateModel")
    public ResponseEntity<SpringateModel> springateModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody SpringateModelData springateModelData){
        Company company = companyService.getCompanyById(companyId);
        if(isNull(springateModelData) || isNull(company)){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankruptcyService.springateModelResult(company, springateModelData));
    }

    @PostMapping(value = "universalDiscriminatoryModel")
    public ResponseEntity<UniversalDiscriminatoryModel> universalDiscriminatoryModelCalculation(@RequestParam(value = "companyId") Long companyId, @RequestBody UniversalDiscriminatoryModelData universalDiscriminatoryModelData){
        Company company = companyService.getCompanyById(companyId);
        if(isNull(universalDiscriminatoryModelData) || isNull(company)){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankruptcyService.universalDiscriminatoryModelResult(company, universalDiscriminatoryModelData));
    }

}
