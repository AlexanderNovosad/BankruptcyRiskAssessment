package com.api.BankruptcyRiskAssessment.entity.unit;

import java.util.List;

public class PreQuantitativeIndicator {
    private String name;
    private double amount;
    private List<QuantitativeIndicator> quantitativeIndicators;

    public PreQuantitativeIndicator(){}

    public PreQuantitativeIndicator(String name, List<QuantitativeIndicator> quantitativeIndicators){
        this.name = name;
        this.quantitativeIndicators = quantitativeIndicators;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<QuantitativeIndicator> getQuantitativeIndicators() {
        return quantitativeIndicators;
    }

    public void setQuantitativeIndicators(List<QuantitativeIndicator> quantitativeIndicators) {
        this.quantitativeIndicators = quantitativeIndicators;
    }
}
