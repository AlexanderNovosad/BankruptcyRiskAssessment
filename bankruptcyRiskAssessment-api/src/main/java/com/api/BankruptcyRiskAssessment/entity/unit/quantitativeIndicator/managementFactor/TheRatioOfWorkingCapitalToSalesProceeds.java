package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class TheRatioOfWorkingCapitalToSalesProceeds {
    String name;
    double workingCapital;
    double salesProceeds;
    double amount;
    int point;

    public TheRatioOfWorkingCapitalToSalesProceeds(String name, Double workingCapital, Double salesProceeds){
        this.name = name;
        this.workingCapital = workingCapital;
        this.salesProceeds = salesProceeds;
        this.amount = workingCapital/salesProceeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWorkingCapital() {
        return workingCapital;
    }

    public void setWorkingCapital(double workingCapital) {
        this.workingCapital = workingCapital;
    }

    public double getSalesProceeds() {
        return salesProceeds;
    }

    public void setSalesProceeds(double salesProceeds) {
        this.salesProceeds = salesProceeds;
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
