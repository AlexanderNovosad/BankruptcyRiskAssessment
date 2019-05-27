package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class RateOfGrowthOfExpenses {
    String name;
    double theFinalValueOfCosts;
    double initialCosts;
    double amount;
    int point;

    public RateOfGrowthOfExpenses(String name, Double theFinalValueOfCosts, Double initialCosts){
        this.name = name;
        this.theFinalValueOfCosts = theFinalValueOfCosts;
        this.initialCosts = initialCosts;
        this.amount = (theFinalValueOfCosts-initialCosts)/initialCosts*100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTheFinalValueOfCosts() {
        return theFinalValueOfCosts;
    }

    public void setTheFinalValueOfCosts(double theFinalValueOfCosts) {
        this.theFinalValueOfCosts = theFinalValueOfCosts;
    }

    public double getInitialCosts() {
        return initialCosts;
    }

    public void setInitialCosts(double initialCosts) {
        this.initialCosts = initialCosts;
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
