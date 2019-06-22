package com.api.BankruptcyRiskAssessment.entity.unit;

public class DavidBelikovModelData {
    double currentAssets;
    double totalValueOfAssets;
    double netProfit;
    double equityCapital;
    double receipts;
    double сost;

    DavidBelikovModelData(){}

    public double getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(double currentAssets) {
        this.currentAssets = currentAssets;
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

    public double getEquityCapital() {
        return equityCapital;
    }

    public void setEquityCapital(double equityCapital) {
        this.equityCapital = equityCapital;
    }

    public double getReceipts() {
        return receipts;
    }

    public void setReceipts(double receipts) {
        this.receipts = receipts;
    }

    public double getСost() {
        return сost;
    }

    public void setСost(double сost) {
        this.сost = сost;
    }
}
