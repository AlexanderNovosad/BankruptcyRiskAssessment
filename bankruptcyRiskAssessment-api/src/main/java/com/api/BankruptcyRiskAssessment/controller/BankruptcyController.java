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
    public ResponseEntity<ArrayList<Indicator>> setTheQualitativeAssessments(@RequestBody ArrayList<Indicator> indicators, @RequestBody List<LinguisticAssessment> assessments){
        return ResponseEntity.ok(bankruptcyService.setThePointsForQualitativeIndicators(indicators, assessments));
    }

    @PostMapping("/NedosekinModel")
    public ResponseEntity<ArrayList<Factor>> calculateBankruptcyPoints(@RequestBody ArrayList<Indicator> productionFactorIndicators, @RequestBody ArrayList<String> productionFactorDependencies, @RequestBody ArrayList<Indicator> managementFactorIndicators, @RequestBody ArrayList<String> managementFactorDependencies, @RequestBody ArrayList<Indicator> financialFactorIndicators, @RequestBody ArrayList<String> financialFactorDependencies, @RequestBody ArrayList<Indicator> personnelFactorIndicators, @RequestBody ArrayList<String> personnelFactorDependencies, @RequestBody ArrayList<Indicator> marketingFactorIndicators, @RequestBody ArrayList<String> marketingFactorDependencies, @RequestBody ArrayList<Indicator> innovationFactorIndicators, @RequestBody ArrayList<String> innovationFactorDependencies, @RequestBody ArrayList<String> factorsDependencies){
        ArrayList<Factor> factors = new ArrayList<>();
        factors.add(bankruptcyService.calculateFactorPoints(productionFactorIndicators, productionFactorDependencies));
        factors.add(bankruptcyService.calculateFactorPoints(managementFactorIndicators, managementFactorDependencies));
        factors.add(bankruptcyService.calculateFactorPoints(financialFactorIndicators, financialFactorDependencies));
        factors.add(bankruptcyService.calculateFactorPoints(personnelFactorIndicators, personnelFactorDependencies));
        factors.add(bankruptcyService.calculateFactorPoints(marketingFactorIndicators, marketingFactorDependencies));
        factors.add(bankruptcyService.calculateFactorPoints(innovationFactorIndicators, innovationFactorDependencies));
        factors.add(bankruptcyService.calculateCompanyPoints(factors,factorsDependencies));
        return ResponseEntity.ok(factors);
    }

}
