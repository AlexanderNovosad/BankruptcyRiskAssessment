package com.api.BankruptcyRiskAssessment.entity.unit;

public class MultiFactorModelOfAltmanData {
    private double currentAssets;
    private double currentLiabilities;
    private double totalValueOfAssets;
    private double netProfit;
    private double profitBeforePayments;
    private double bookValueOfEquity;
    private double obligation;
    private double receipts;

    MultiFactorModelOfAltmanData(){}

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

    public double getTotalValueOfAssets() {
        return totalValueOfAssets;
    }

    public void setTotalValueOfAssets(double totalValueOfAssets) {
        this.totalValueOfAssets = totalValueOfAssets;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getProfitBeforePayments() {
        return profitBeforePayments;
    }

    public void setProfitBeforePayments(double profitBeforePayments) {
        this.profitBeforePayments = profitBeforePayments;
    }

    public double getBookValueOfEquity() {
        return bookValueOfEquity;
    }

    public void setBookValueOfEquity(double bookValueOfEquity) {
        this.bookValueOfEquity = bookValueOfEquity;
    }

    public double getObligation() {
        return obligation;
    }

    public void setObligation(double obligation) {
        this.obligation = obligation;
    }

    public double getReceipts() {
        return receipts;
    }

    public void setReceipts(double receipts) {
        this.receipts = receipts;
    }
}
