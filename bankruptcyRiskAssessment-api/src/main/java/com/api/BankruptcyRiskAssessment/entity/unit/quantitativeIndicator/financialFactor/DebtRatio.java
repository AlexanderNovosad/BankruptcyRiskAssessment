package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;


// Коефіцієнт заборгованості
public class DebtRatio {

    double capitalAttracted;
    double assets;

    double amount;

    public DebtRatio(double capitalAttracted, double assets) {
        this.capitalAttracted = capitalAttracted;
        this.assets = assets;

        this.amount = capitalAttracted / assets;
    }

    public double getCapitalAttracted() {
        return capitalAttracted;
    }

    public void setCapitalAttracted(double capitalAttracted) {
        this.capitalAttracted = capitalAttracted;
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
