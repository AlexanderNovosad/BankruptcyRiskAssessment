package com.api.BankruptcyRiskAssessment.entity.unit;

public class LissModelData {
    private double workingCapital;
    private double amountOfAssets;
    private double profitFromSales;
    private double undividedProfit;
    private double equityCapital;
    private double attractedCapital;

    LissModelData(){}

    public double getWorkingCapital() {
        return workingCapital;
    }

    public void setWorkingCapital(double workingCapital) {
        this.workingCapital = workingCapital;
    }

    public double getAmountOfAssets() {
        return amountOfAssets;
    }

    public void setAmountOfAssets(double amountOfAssets) {
        this.amountOfAssets = amountOfAssets;
    }

    public double getProfitFromSales() {
        return profitFromSales;
    }

    public void setProfitFromSales(double profitFromSales) {
        this.profitFromSales = profitFromSales;
    }

    public double getUndividedProfit() {
        return undividedProfit;
    }

    public void setUndividedProfit(double undividedProfit) {
        this.undividedProfit = undividedProfit;
    }

    public double getEquityCapital() {
        return equityCapital;
    }

    public void setEquityCapital(double equityCapital) {
        this.equityCapital = equityCapital;
    }

    public double getAttractedCapital() {
        return attractedCapital;
    }

    public void setAttractedCapital(double attractedCapital) {
        this.attractedCapital = attractedCapital;
    }
}
