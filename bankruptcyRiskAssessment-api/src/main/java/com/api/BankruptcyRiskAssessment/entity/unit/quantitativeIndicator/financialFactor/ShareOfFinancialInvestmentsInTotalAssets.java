package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Питома вага фінансових інвестицій в загальній сумі активів
public class ShareOfFinancialInvestmentsInTotalAssets {

    double financialInvestments;
    double assets;
    double amount;

    public ShareOfFinancialInvestmentsInTotalAssets(double financialInvestments, double assets) {
        this.financialInvestments = financialInvestments;
        this.assets = assets;
        this.amount = financialInvestments / assets * 100;
    }

    public double getFinancialInvestments() {
        return financialInvestments;
    }

    public void setFinancialInvestments(double financialInvestments) {
        this.financialInvestments = financialInvestments;
    }

    public double getAssets() {
        return assets;
    }

    public void setAssets(double assets) {
        this.assets = assets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
