package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

// Відновлення основного капіталу до суми чистих активів
public class RestorationOfFixedCapitalToAmountOfNetAssets {

    double nonCurrentAssets;
    double netAssets;

    double amount;

    public RestorationOfFixedCapitalToAmountOfNetAssets(double nonCurrentAssets, double netAssets) {
        this.nonCurrentAssets = nonCurrentAssets;
        this.netAssets = netAssets;
        this.amount = nonCurrentAssets / netAssets;
    }

    public double getNonCurrentAssets() {
        return nonCurrentAssets;
    }

    public void setNonCurrentAssets(double nonCurrentAssets) {
        this.nonCurrentAssets = nonCurrentAssets;
    }

    public double getNetAssets() {
        return netAssets;
    }

    public void setNetAssets(double netAssets) {
        this.netAssets = netAssets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
