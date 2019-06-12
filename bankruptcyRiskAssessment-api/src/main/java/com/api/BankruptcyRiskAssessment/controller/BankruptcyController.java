package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.unit.Factor;
import com.api.BankruptcyRiskAssessment.entity.unit.Indicator;
import com.api.BankruptcyRiskAssessment.entity.unit.LinguisticAssessment;
import com.api.BankruptcyRiskAssessment.entity.unit.QuantitativeIndicator;
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
    public ResponseEntity<ArrayList<Indicator>> setTheAssessments(@RequestBody ArrayList<Indicator> indicators, @RequestBody List<LinguisticAssessment> assessments){
        return ResponseEntity.ok(bankruptcyService.setThePointsForIndicators(indicators, assessments));
    }

    @PostMapping("/NedosekinModel")
    public ResponseEntity<ArrayList<Factor>> calculateBankruptcyPoints(@RequestParam(value = "company_id") Long companyId, @RequestBody List<ArrayList<Indicator>> indicators, @RequestBody List<ArrayList<String>> dependencies, @RequestBody ArrayList<String> factorsDependencies){
        ArrayList<Factor> factors = new ArrayList<>();
        for(int i=0; i<indicators.size(); i++){
            factors.add(bankruptcyService.calculateFactorPoints(indicators.get(i), dependencies.get(i)));
        }
        factors.add(bankruptcyService.calculateCompanyPoints(factors,factorsDependencies));
        return ResponseEntity.ok(factors);
    }

    @GetMapping("/factors")
    public ResponseEntity<ArrayList<Factor>> getFactors(){
        ArrayList<Factor> factors = new ArrayList<>();
        factors = bankruptcyService.createFactors();
        return ResponseEntity.ok(factors);
    }

    @PostMapping("/indicators/QualitativeIndicators")
    public ResponseEntity<ArrayList<Indicator>> getQualitativeIndicators(@RequestBody List<Factor> factors){
        if (isNull(factors)) {
            return ResponseEntity.notFound().build();
        }
        ArrayList<Indicator> indicators = new ArrayList<>();
        indicators = bankruptcyService.createQualitativeIndicators(factors);
        if (isNull(indicators)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(indicators);
    }

    @PostMapping("/indicators/QuantitativeIndicators")
    public ResponseEntity<ArrayList<QuantitativeIndicator>> getQuantitativeIndicators(@RequestBody List<Factor> factors){
        if (isNull(factors)) {
            return ResponseEntity.notFound().build();
        }
        ArrayList<QuantitativeIndicator> indicators = new ArrayList<>();
        indicators = bankruptcyService.createQuantitativeIndicators(factors);
        if (isNull(indicators)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(indicators);
    }

}
