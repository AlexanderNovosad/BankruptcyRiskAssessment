package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Відношення власного оборотного капіталу до суми активів
public class RatioOfOwnWorkingCapitalToTheAmountOfAssets {

    double ownWorkingCapital;
    double amountOfAssets;
    double amount;

    public RatioOfOwnWorkingCapitalToTheAmountOfAssets(double ownWorkingCapital, double amountOfAssets) {
        this.ownWorkingCapital = ownWorkingCapital;
        this.amountOfAssets = amountOfAssets;

        this.amount = ownWorkingCapital / amountOfAssets;
    }

    public double getOwnWorkingCapital() {
        return ownWorkingCapital;
    }

    public void setOwnWorkingCapital(double ownWorkingCapital) {
        this.ownWorkingCapital = ownWorkingCapital;
    }

    public double getAmountOfAssets() {
        return amountOfAssets;
    }

    public void setAmountOfAssets(double amountOfAssets) {
        this.amountOfAssets = amountOfAssets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
