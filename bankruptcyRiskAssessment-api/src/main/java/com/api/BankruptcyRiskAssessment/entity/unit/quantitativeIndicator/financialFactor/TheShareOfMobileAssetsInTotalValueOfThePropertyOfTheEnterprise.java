package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

// Частка мобільних активів у загальній величині майна підприємства
public class TheShareOfMobileAssetsInTotalValueOfThePropertyOfTheEnterprise {

    double currentAssets;
    double assets;
    double amount;

    public TheShareOfMobileAssetsInTotalValueOfThePropertyOfTheEnterprise(double currentAssets, double assets) {
        this.currentAssets = currentAssets;
        this.assets = assets;

        this.amount = currentAssets / assets;
    }

    public double getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(double currentAssets) {
        this.currentAssets = currentAssets;
    }

    public double getAssets() {
        return assets;
    }

    public void setAssets(double assets) {
        this.assets = assets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
