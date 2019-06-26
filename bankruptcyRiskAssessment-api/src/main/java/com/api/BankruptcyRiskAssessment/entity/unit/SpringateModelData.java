package com.api.BankruptcyRiskAssessment.entity.unit;

public class SpringateModelData {
    private double workingCapital;
    private double totalValueOfAssets;
    private double profitFromSales;
    private double shortTermDebt;
    private double salesVolume;

    SpringateModelData(){}

    public double getWorkingCapital() {
        return workingCapital;
    }

    public void setWorkingCapital(double workingCapital) {
        this.workingCapital = workingCapital;
    }

    public double getTotalValueOfAssets() {
        return totalValueOfAssets;
    }

    public void setTotalValueOfAssets(double totalValueOfAssets) {
        this.totalValueOfAssets = totalValueOfAssets;
    }

    public double getProfitFromSales() {
        return profitFromSales;
    }

    public void setProfitFromSales(double profitFromSales) {
        this.profitFromSales = profitFromSales;
    }

    public double getShortTermDebt() {
        return shortTermDebt;
    }

    public void setShortTermDebt(double shortTermDebt) {
        this.shortTermDebt = shortTermDebt;
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }
}
