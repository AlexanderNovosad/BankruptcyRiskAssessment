package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class OwnWorkingCapital {

    double equity;
    double nonCurrentAssets;

    double amount;

    public OwnWorkingCapital(double equity, double nonCurrentAssets) {
        this.equity = equity;
        this.nonCurrentAssets = nonCurrentAssets;

        this.amount = equity - nonCurrentAssets;
    }

    public double getEquity() {
        return equity;
    }

    public void setEquity(double equity) {
        this.equity = equity;
    }

    public double getNonCurrentAssets() {
        return nonCurrentAssets;
    }

    public void setNonCurrentAssets(double nonCurrentAssets) {
        this.nonCurrentAssets = nonCurrentAssets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
