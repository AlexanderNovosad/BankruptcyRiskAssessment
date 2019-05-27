package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;


public class TurnoverOfAccountsPayable {
    String name;
    double costOfSales;
    double averageAnnualCostOfAccountsPayable;
    double amount;
    int point;

    public TurnoverOfAccountsPayable(String name, Double costOfSales, Double averageAnnualCostOfAccountsPayable){
        this.name = name;
        this.costOfSales = costOfSales;
        this.averageAnnualCostOfAccountsPayable = averageAnnualCostOfAccountsPayable;
        this.amount = costOfSales/averageAnnualCostOfAccountsPayable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostOfSales() {
        return costOfSales;
    }

    public void setCostOfSales(double costOfSales) {
        this.costOfSales = costOfSales;
    }

    public double getAverageAnnualCostOfAccountsPayable() {
        return averageAnnualCostOfAccountsPayable;
    }

    public void setAverageAnnualCostOfAccountsPayable(double averageAnnualCostOfAccountsPayable) {
        this.averageAnnualCostOfAccountsPayable = averageAnnualCostOfAccountsPayable;
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
