package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class ProfitabilityOfNetAssets {

    double netProfit;
    double averageAnnualValueOfNetAssets;
    double amount;


    public ProfitabilityOfNetAssets(double netProfit, double averageAnnualValueOfNetAssets) {
        this.netProfit = netProfit;
        this.averageAnnualValueOfNetAssets = averageAnnualValueOfNetAssets;

        this.amount = netProfit / averageAnnualValueOfNetAssets * 100;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getAverageAnnualValueOfNetAssets() {
        return averageAnnualValueOfNetAssets;
    }

    public void setAverageAnnualValueOfNetAssets(double averageAnnualValueOfNetAssets) {
        this.averageAnnualValueOfNetAssets = averageAnnualValueOfNetAssets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
