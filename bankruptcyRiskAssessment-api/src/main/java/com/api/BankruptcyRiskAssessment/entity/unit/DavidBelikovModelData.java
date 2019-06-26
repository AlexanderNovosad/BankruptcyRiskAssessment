package com.api.BankruptcyRiskAssessment.entity.unit;

public class DavidBelikovModelData {
    private double currentAssets;
    private double totalValueOfAssets;
    private double netProfit;
    private double equityCapital;
    private double receipts;
    private double cost;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
