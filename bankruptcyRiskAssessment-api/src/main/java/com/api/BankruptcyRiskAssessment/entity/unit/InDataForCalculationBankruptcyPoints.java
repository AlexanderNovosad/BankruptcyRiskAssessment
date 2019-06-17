package com.api.BankruptcyRiskAssessment.entity.unit;

import java.util.List;

public class InDataForCalculationBankruptcyPoints {
    private List<List<Indicator>> indicators;
    private List<List<String>> dependencies;
    private List<String> factorsDependencies;

    InDataForCalculationBankruptcyPoints(){}

    public List<List<Indicator>> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<List<Indicator>> indicators) {
        this.indicators = indicators;
    }

    public List<List<String>> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<List<String>> dependencies) {
        this.dependencies = dependencies;
    }

    public List<String> getFactorsDependencies() {
        return factorsDependencies;
    }

    public void setFactorsDependencies(List<String> factorsDependencies) {
        this.factorsDependencies = factorsDependencies;
    }
}
