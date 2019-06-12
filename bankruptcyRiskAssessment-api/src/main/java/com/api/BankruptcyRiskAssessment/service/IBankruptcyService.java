package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.unit.Factor;
import com.api.BankruptcyRiskAssessment.entity.unit.Indicator;
import com.api.BankruptcyRiskAssessment.entity.unit.LinguisticAssessment;
import com.api.BankruptcyRiskAssessment.entity.unit.QuantitativeIndicator;

import java.util.ArrayList;
import java.util.List;

public interface IBankruptcyService {

    ArrayList<Indicator> setThePointsForIndicators(ArrayList<Indicator> indicators, List<LinguisticAssessment> assessments);

    ArrayList<Indicator> createQualitativeIndicators(List<Factor> factors);

    ArrayList<QuantitativeIndicator> createQuantitativeIndicators(List<Factor> factors);

    ArrayList<Factor> createFactors();

//    ArrayList<QuantitativeIndicator> setThePointsQuantitativeIndicators(ArrayList<QuantitativeIndicator> indicators, List<LinguisticAssessment> assessments);

    Factor calculateFactorPoints(ArrayList<Indicator> factorIndicators, ArrayList<String> factorDependencies);

    Factor calculateCompanyPoints(ArrayList<Factor> factors, ArrayList<String> factorsDependencies);

}
