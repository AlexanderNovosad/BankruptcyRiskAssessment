package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Рентабельність власного капіталу
public class ReturnOnEquity {


    double netProfit;
    double averageAnnualCostOfEquityCapital;
    double amount;

    public ReturnOnEquity(double netProfit, double averageAnnualCostOfEquityCapital) {
        this.netProfit = netProfit;
        this.averageAnnualCostOfEquityCapital = averageAnnualCostOfEquityCapital;
        this.amount = netProfit / averageAnnualCostOfEquityCapital * 100;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getAverageAnnualCostOfEquityCapital() {
        return averageAnnualCostOfEquityCapital;
    }

    public void setAverageAnnualCostOfEquityCapital(double averageAnnualCostOfEquityCapital) {
        this.averageAnnualCostOfEquityCapital = averageAnnualCostOfEquityCapital;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
