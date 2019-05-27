package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.productionFactor;

public class LaborProductivity {
    String name;
    double netProceeds;
    int averageAnnualNumberOfEmployees;
    double amount;
    int point;

    public LaborProductivity(String name, Double netProceeds, Integer averageAnnualNumberOfEmployees){
        this.name = name;
        this.netProceeds = netProceeds;
        this.averageAnnualNumberOfEmployees = averageAnnualNumberOfEmployees;
        this.amount = netProceeds/averageAnnualNumberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNetProceeds() {
        return netProceeds;
    }

    public void setNetProceeds(double netProceeds) {
        this.netProceeds = netProceeds;
    }

    public int getAverageAnnualNumberOfEmployees() {
        return averageAnnualNumberOfEmployees;
    }

    public void setAverageAnnualNumberOfEmployees(int averageAnnualNumberOfEmployees) {
        this.averageAnnualNumberOfEmployees = averageAnnualNumberOfEmployees;
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
