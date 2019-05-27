package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class TheRatioOfReturnOnSalesToTheAmountOfAssets {
    String name;
    double profitFromSales;
    double amountOfAssets;
    double amount;
    int point;

    public TheRatioOfReturnOnSalesToTheAmountOfAssets(String name, Double profitFromSales, Double amountOfAssets){
        this.name = name;
        this.profitFromSales = profitFromSales;
        this.amountOfAssets = amountOfAssets;
        this.amount = profitFromSales/amountOfAssets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProfitFromSales() {
        return profitFromSales;
    }

    public void setProfitFromSales(double profitFromSales) {
        this.profitFromSales = profitFromSales;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
