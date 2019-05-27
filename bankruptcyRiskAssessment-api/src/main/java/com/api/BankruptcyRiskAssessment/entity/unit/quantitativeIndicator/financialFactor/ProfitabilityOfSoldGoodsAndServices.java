package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Рентабельність реалізованих товарів, робіт послуг
public class ProfitabilityOfSoldGoodsAndServices {

    double netProfit;
    double costOfGoodsSold;
    double amount;

    public ProfitabilityOfSoldGoodsAndServices(double netProfit, double costOfGoodsSold) {
        this.netProfit = netProfit;
        this.costOfGoodsSold = costOfGoodsSold;

        this.amount = netProfit / costOfGoodsSold * 100;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getCostOfGoodsSold() {
        return costOfGoodsSold;
    }

    public void setCostOfGoodsSold(double costOfGoodsSold) {
        this.costOfGoodsSold = costOfGoodsSold;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
