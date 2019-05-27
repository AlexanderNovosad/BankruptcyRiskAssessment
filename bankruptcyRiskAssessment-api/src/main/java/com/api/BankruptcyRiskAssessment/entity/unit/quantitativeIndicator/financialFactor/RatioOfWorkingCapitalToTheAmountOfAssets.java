package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Відношення оборотного капіталу до суми активів
public class RatioOfWorkingCapitalToTheAmountOfAssets {
    double workingCapital;
    double assets;

    double amount;

    public RatioOfWorkingCapitalToTheAmountOfAssets(double workingCapital, double assets) {
        this.workingCapital = workingCapital;
        this.assets = assets;

        this.amount = workingCapital / assets;
    }

    public double getWorkingCapital() {
        return workingCapital;
    }

    public void setWorkingCapital(double workingCapital) {
        this.workingCapital = workingCapital;
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
