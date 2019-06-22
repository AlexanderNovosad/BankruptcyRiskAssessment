package com.api.BankruptcyRiskAssessment.entity.unit;

public class UniversalDiscriminatoryModelData {
    double cashFlow;
    double obligation;
    double totalValueOfAssets;
    double netProfit;
    double receipts;
    double inventories;

    UniversalDiscriminatoryModelData(){}

    public double getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(double cashFlow) {
        this.cashFlow = cashFlow;
    }

    public double getObligation() {
        return obligation;
    }

    public void setObligation(double obligation) {
        this.obligation = obligation;
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

    public double getReceipts() {
        return receipts;
    }

    public void setReceipts(double receipts) {
        this.receipts = receipts;
    }

    public double getInventories() {
        return inventories;
    }

    public void setInventories(double inventories) {
        this.inventories = inventories;
    }
}
