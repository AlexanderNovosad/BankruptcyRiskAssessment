package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Відношення власного капіталу до залученого
public class EquityRatioToBorrowed {
    double equity;
    double capitalIsAttracted;
    double amount;

    public EquityRatioToBorrowed(double equity, double capitalIsAttracted) {
        this.equity = equity;
        this.capitalIsAttracted = capitalIsAttracted;

        this.amount = equity / capitalIsAttracted;
    }

    public double getEquity() {
        return equity;
    }

    public void setEquity(double equity) {
        this.equity = equity;
    }

    public double getCapitalIsAttracted() {
        return capitalIsAttracted;
    }

    public void setCapitalIsAttracted(double capitalIsAttracted) {
        this.capitalIsAttracted = capitalIsAttracted;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
