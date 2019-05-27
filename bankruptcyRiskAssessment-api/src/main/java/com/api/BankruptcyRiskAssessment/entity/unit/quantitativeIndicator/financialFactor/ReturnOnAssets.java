package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class ReturnOnAssets {
    double netProfit;
    double averageAnnualValueOfAssets;
    double amount;

    public ReturnOnAssets(double netProfit, double averageAnnualValueOfAssets) {
        this.netProfit = netProfit;
        this.averageAnnualValueOfAssets = averageAnnualValueOfAssets;
        this.amount = netProfit / averageAnnualValueOfAssets * 100;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getAverageAnnualValueOfAssets() {
        return averageAnnualValueOfAssets;
    }

    public void setAverageAnnualValueOfAssets(double averageAnnualValueOfAssets) {
        this.averageAnnualValueOfAssets = averageAnnualValueOfAssets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
