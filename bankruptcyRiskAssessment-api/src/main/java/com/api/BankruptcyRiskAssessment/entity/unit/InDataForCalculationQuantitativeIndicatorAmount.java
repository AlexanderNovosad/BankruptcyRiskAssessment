package com.api.BankruptcyRiskAssessment.entity.unit;

import java.util.List;

public class InDataForCalculationQuantitativeIndicatorAmount {
    private List<QuantitativeIndicator> quantitativeIndicators;
    private List<PreQuantitativeIndicator> preQuantitativeIndicators;

    InDataForCalculationQuantitativeIndicatorAmount(){}

    public List<QuantitativeIndicator> getQuantitativeIndicators() {
        return quantitativeIndicators;
    }

    public void setQuantitativeIndicators(List<QuantitativeIndicator> quantitativeIndicators) {
        this.quantitativeIndicators = quantitativeIndicators;
    }

    public List<PreQuantitativeIndicator> getPreQuantitativeIndicators() {
        return preQuantitativeIndicators;
    }

    public void setPreQuantitativeIndicators(List<PreQuantitativeIndicator> preQuantitativeIndicators) {
        this.preQuantitativeIndicators = preQuantitativeIndicators;
    }
}
