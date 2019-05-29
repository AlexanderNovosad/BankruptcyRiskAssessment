package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class RatioOfLiabilitiesToEquity {
    double obligation;
    double equity;
    double amount;

    public RatioOfLiabilitiesToEquity(double obligation, double equity) {
        this.obligation = obligation;
        this.equity = equity;

        this.amount = obligation / equity;
    }

    public double getObligation() {
        return obligation;
    }

    public void setObligation(double obligation) {
        this.obligation = obligation;
    }

    public double getEquity() {
        return equity;
    }

    public void setEquity(double equity) {
        this.equity = equity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
