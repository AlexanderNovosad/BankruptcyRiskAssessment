package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.unit.Factor;
import com.api.BankruptcyRiskAssessment.entity.unit.Indicator;
import com.api.BankruptcyRiskAssessment.entity.unit.LinguisticAssessment;
import com.api.BankruptcyRiskAssessment.service.IBankruptcyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<ArrayList<Factor>> calculateBankruptcyPoints(@RequestBody List<ArrayList<Indicator>> indicators, @RequestBody List<ArrayList<String>> dependencies, @RequestBody ArrayList<String> factorsDependencies){
        ArrayList<Factor> factors = new ArrayList<>();
        for(int i=0; i<indicators.size(); i++){
            factors.add(bankruptcyService.calculateFactorPoints(indicators.get(i), dependencies.get(i)));
        }
        factors.add(bankruptcyService.calculateCompanyPoints(factors,factorsDependencies));
        return ResponseEntity.ok(factors);
    }

}
