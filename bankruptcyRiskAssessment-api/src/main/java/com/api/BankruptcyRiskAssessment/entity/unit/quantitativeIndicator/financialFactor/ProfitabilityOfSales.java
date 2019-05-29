package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class ProfitabilityOfSales {

    double operatingProfit;
    double netProceeds;
    double amount;

    public ProfitabilityOfSales(double operatingProfit, double netProceeds) {
        this.operatingProfit = operatingProfit;
        this.netProceeds = netProceeds;

        this.amount = operatingProfit / netProceeds * 100;
    }

    public double getOperatingProfit() {
        return operatingProfit;
    }

    public void setOperatingProfit(double operatingProfit) {
        this.operatingProfit = operatingProfit;
    }

    public double getNetProceeds() {
        return netProceeds;
    }

    public void setNetProceeds(double netProceeds) {
        this.netProceeds = netProceeds;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
