package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;


//Оборотність активів
public class AssetTurnover {

    double revenueFromSales;
    double averageAnnualValueOfAssets;
    double amount;

    public AssetTurnover(double revenueFromSales, double averageAnnualValueOfAssets) {
        this.revenueFromSales = revenueFromSales;
        this.averageAnnualValueOfAssets = averageAnnualValueOfAssets;

        this.amount = revenueFromSales / averageAnnualValueOfAssets;
    }

    public double getRevenueFromSales() {
        return revenueFromSales;
    }

    public void setRevenueFromSales(double revenueFromSales) {
        this.revenueFromSales = revenueFromSales;
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
