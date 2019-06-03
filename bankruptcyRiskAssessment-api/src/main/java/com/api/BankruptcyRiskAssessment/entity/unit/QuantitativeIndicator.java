package com.api.BankruptcyRiskAssessment.entity.unit;

public class QuantitativeIndicator extends Indicator {
    private double amount;

    public QuantitativeIndicator(String name, Double amount){
        super(name);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}