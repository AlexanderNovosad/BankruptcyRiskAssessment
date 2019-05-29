package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.financialFactor;

//Відношення прибутку до сплати податків до суми активів
public class RatioOfProfitBeforeTaxToTheAmountOfAssets {


    double profitToPayTaxes;
    double amountOfAssets;
    double amount;

    public RatioOfProfitBeforeTaxToTheAmountOfAssets(double profitToPayTaxes, double amountOfAssets) {
        this.profitToPayTaxes = profitToPayTaxes;
        this.amountOfAssets = amountOfAssets;

        this.amount = profitToPayTaxes / amountOfAssets;
    }

    public double getProfitToPayTaxes() {
        return profitToPayTaxes;
    }

    public void setProfitToPayTaxes(double profitToPayTaxes) {
        this.profitToPayTaxes = profitToPayTaxes;
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
