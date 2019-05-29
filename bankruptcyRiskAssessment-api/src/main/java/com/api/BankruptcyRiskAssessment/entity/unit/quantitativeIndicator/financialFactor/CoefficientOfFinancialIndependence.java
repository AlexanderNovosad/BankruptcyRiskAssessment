package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Коефіцієнт фінансової незалежності
public class CoefficientOfFinancialIndependence {


    double equity;
    double assets;
    double amount;

    public CoefficientOfFinancialIndependence(double equity, double assets) {
        this.equity = equity;
        this.assets = assets;

        this.amount = equity / assets;
    }

    public double getEquity() {
        return equity;
    }

    public void setEquity(double equity) {
        this.equity = equity;
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
