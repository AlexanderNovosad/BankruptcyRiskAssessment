package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class ProfitabilityOfCurrentAssets {

    double operatingProfit;
    double averageAnnualValueOfCurrentAssets;
    double amount;

    public ProfitabilityOfCurrentAssets(double operatingProfit, double averageAnnualValueOfCurrentAssets) {
        this.operatingProfit = operatingProfit;
        this.averageAnnualValueOfCurrentAssets = averageAnnualValueOfCurrentAssets;

        this.amount = operatingProfit / averageAnnualValueOfCurrentAssets * 100;
    }

    public double getOperatingProfit() {
        return operatingProfit;
    }

    public void setOperatingProfit(double operatingProfit) {
        this.operatingProfit = operatingProfit;
    }

    public double getAverageAnnualValueOfCurrentAssets() {
        return averageAnnualValueOfCurrentAssets;
    }

    public void setAverageAnnualValueOfCurrentAssets(double averageAnnualValueOfCurrentAssets) {
        this.averageAnnualValueOfCurrentAssets = averageAnnualValueOfCurrentAssets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
