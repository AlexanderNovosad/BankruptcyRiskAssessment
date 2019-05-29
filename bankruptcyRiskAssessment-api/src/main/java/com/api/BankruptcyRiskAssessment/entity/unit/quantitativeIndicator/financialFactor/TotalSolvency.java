package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class TotalSolvency {

    double currentAssets;
    double currentLiabilities;
    double amount;

    public TotalSolvency(double currentAssets, double currentLiabilities) {
        this.currentAssets = currentAssets;
        this.currentLiabilities = currentLiabilities;

        this.amount = currentAssets / currentLiabilities;
    }

    public double getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(double currentAssets) {
        this.currentAssets = currentAssets;
    }

    public double getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(double currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
