package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Прибутковість фінансових інвестицій
public class ProfitabilityOfFinancialInvestments {

    double profit;
    double financialInvestments;
    double amount;

    public ProfitabilityOfFinancialInvestments(double profit, double financialInvestments) {
        this.profit = profit;
        this.financialInvestments = financialInvestments;

        this.amount = profit / financialInvestments;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getFinancialInvestments() {
        return financialInvestments;
    }

    public void setFinancialInvestments(double financialInvestments) {
        this.financialInvestments = financialInvestments;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
