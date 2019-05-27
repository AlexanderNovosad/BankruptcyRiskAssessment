package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class RateOfIncomeGrowth {
    String name;
    double theFinalValueOfRevenues;
    double initialRevenues;
    double amount;
    int point;


    public RateOfIncomeGrowth(String name, Double theFinalValueOfRevenues, Double initialRevenues){
        this.name = name;
        this.theFinalValueOfRevenues = theFinalValueOfRevenues;
        this.initialRevenues = initialRevenues;
        this.amount = (theFinalValueOfRevenues - initialRevenues)/initialRevenues*100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTheFinalValueOfRevenues() {
        return theFinalValueOfRevenues;
    }

    public void setTheFinalValueOfRevenues(double theFinalValueOfRevenues) {
        this.theFinalValueOfRevenues = theFinalValueOfRevenues;
    }

    public double getInitialRevenues() {
        return initialRevenues;
    }

    public void setInitialRevenues(double initialRevenues) {
        this.initialRevenues = initialRevenues;
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
