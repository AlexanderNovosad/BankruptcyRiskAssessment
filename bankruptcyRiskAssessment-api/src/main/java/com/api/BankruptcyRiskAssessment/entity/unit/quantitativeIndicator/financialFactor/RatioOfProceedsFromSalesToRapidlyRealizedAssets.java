package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;


//Відношення надходжень від реалізації до швидко реалізованих активів
public class RatioOfProceedsFromSalesToRapidlyRealizedAssets {

    double revenueFromSales;
    double quicklyRealizedAssets;

    double amount;

    public RatioOfProceedsFromSalesToRapidlyRealizedAssets(double revenueFromSales, double quicklyRealizedAssets) {
        this.revenueFromSales = revenueFromSales;
        this.quicklyRealizedAssets = quicklyRealizedAssets;

        this.amount = revenueFromSales / quicklyRealizedAssets;
    }

    public double getRevenueFromSales() {
        return revenueFromSales;
    }

    public void setRevenueFromSales(double revenueFromSales) {
        this.revenueFromSales = revenueFromSales;
    }

    public double getQuicklyRealizedAssets() {
        return quicklyRealizedAssets;
    }

    public void setQuicklyRealizedAssets(double quicklyRealizedAssets) {
        this.quicklyRealizedAssets = quicklyRealizedAssets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
