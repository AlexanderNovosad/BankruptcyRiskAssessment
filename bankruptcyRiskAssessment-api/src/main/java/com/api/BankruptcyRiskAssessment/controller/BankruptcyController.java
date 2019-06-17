package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.unit.*;
import com.api.BankruptcyRiskAssessment.service.IBankruptcyService;
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
    public ResponseEntity<List<Factor>> calculateBankruptcyPoints(@RequestParam(value = "company_id") Long companyId, @RequestBody InDataForCalculationBankruptcyPoints inDataForCalculationBankruptcyPoints){
        ArrayList<Factor> factors = new ArrayList<>();
        List<List<Indicator>> indicators = inDataForCalculationBankruptcyPoints.getIndicators();
        List<List<String>> dependencies = inDataForCalculationBankruptcyPoints.getDependencies();
        List<String> factorsDependencies = inDataForCalculationBankruptcyPoints.getFactorsDependencies();
        if(isNull(indicators) || isNull(dependencies) || isNull(factorsDependencies)){
            return ResponseEntity.notFound().build();
        }
        for(int i=0; i<indicators.size(); i++){
            factors.add(bankruptcyService.calculateFactorPoints(indicators.get(i), dependencies.get(i)));
        }
        factors.add(bankruptcyService.calculateCompanyPoints(factors,factorsDependencies));
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

}
