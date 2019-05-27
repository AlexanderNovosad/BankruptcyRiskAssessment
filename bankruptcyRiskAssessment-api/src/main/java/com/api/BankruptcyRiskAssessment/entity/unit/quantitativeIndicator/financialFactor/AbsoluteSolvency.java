package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

public class AbsoluteSolvency {

    double cash;
    double currentLiabilities;
    double amount;

    public AbsoluteSolvency(double cash, double currentLiabilities) {
        this.cash = cash;
        this.currentLiabilities = currentLiabilities;

        this.amount = cash / currentLiabilities;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(double currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
