package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.*;
import com.api.BankruptcyRiskAssessment.entity.unit.*;

import java.util.List;

public interface IBankruptcyService {

    List<Indicator> setThePointsForIndicators(List<Indicator> indicators, List<LinguisticAssessment> assessments);

    List<Indicator> getQualitativeIndicators();

    List<QuantitativeIndicator> getQuantitativeIndicators();

    List<PreQuantitativeIndicator> getPreQuantitativeIndicators(List<QuantitativeIndicator> quantitativeIndicators);

    List<QuantitativeIndicator> calculateAmountOfQuantitativeIndicators(List<QuantitativeIndicator> quantitativeIndicators, List<PreQuantitativeIndicator> preQuantitativeIndicators);

    List<Factor> getFactors();

    Factor calculateFactorPoints(Company company, List<Indicator> factorIndicators, List<String> factorDependencies);

    Factor calculateCompanyPoints(Company company, List<Factor> factors, List<String> factorsDependencies);

    MultiFactorModelOfAltman multiFactorModelOfAltmanResult(Company company, MultiFactorModelOfAltmanData multiFactorModelOfAltmanData);

    LissModel lissModelResult(Company company, LissModelData lissModelData);

    DavidBelikovModel davidBelikovModelResult(Company company, DavidBelikovModelData davidBelikovModelData);

    SpringateModel springateModelResult(Company company, SpringateModelData springateModelData);

    UniversalDiscriminatoryModel universalDiscriminatoryModelResult(Company company, UniversalDiscriminatoryModelData universalDiscriminatoryModelData);

}
