package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.unit.*;

import java.util.List;

public interface IBankruptcyService {

    List<Indicator> setThePointsForIndicators(List<Indicator> indicators, List<LinguisticAssessment> assessments);

    List<Indicator> getQualitativeIndicators();

    List<QuantitativeIndicator> getQuantitativeIndicators();

    List<PreQuantitativeIndicator> getPreQuantitativeIndicators(List<QuantitativeIndicator> quantitativeIndicators);

    List<QuantitativeIndicator> calculateAmountOfQuantitativeIndicators(List<QuantitativeIndicator> quantitativeIndicators, List<PreQuantitativeIndicator> preQuantitativeIndicators);

    List<Factor> getFactors();

    Factor calculateFactorPoints(List<Indicator> factorIndicators, List<String> factorDependencies);

    Factor calculateCompanyPoints(List<Factor> factors, List<String> factorsDependencies);

}
