package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class IntermediateSolvency {


    double currentAssets;
    double inventories;
    double currentLiabilities;
    double amount;

    public IntermediateSolvency(double currentAssets, double inventories, double currentLiabilities) {
        this.currentAssets = currentAssets;
        this.inventories = inventories;
        this.currentLiabilities = currentLiabilities;

        this.amount = (currentAssets - inventories) / currentLiabilities;
    }

    public double getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(double currentAssets) {
        this.currentAssets = currentAssets;
    }

    public double getInventories() {
        return inventories;
    }

    public void setInventories(double inventories) {
        this.inventories = inventories;
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
