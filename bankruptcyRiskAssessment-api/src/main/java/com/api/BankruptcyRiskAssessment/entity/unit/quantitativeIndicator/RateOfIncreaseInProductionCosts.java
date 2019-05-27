package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator;

public class RateOfIncreaseInProductionCosts {
    String name;
    double theFinalValueOfTheCostOfProduction;
    double theInitialValueOfTheCostOfProduction;
    double amount;
    int point;

    public RateOfIncreaseInProductionCosts(String name, Double theFinalValueOfTheCostOfProduction, Double theInitialValueOfTheCostOfProduction){
        this.name = name;
        this.theFinalValueOfTheCostOfProduction = theFinalValueOfTheCostOfProduction;
        this.theInitialValueOfTheCostOfProduction = theInitialValueOfTheCostOfProduction;
        this.amount = (theFinalValueOfTheCostOfProduction-theInitialValueOfTheCostOfProduction)/theInitialValueOfTheCostOfProduction*100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTheFinalValueOfTheCostOfProduction() {
        return theFinalValueOfTheCostOfProduction;
    }

    public void setTheFinalValueOfTheCostOfProduction(double theFinalValueOfTheCostOfProduction) {
        this.theFinalValueOfTheCostOfProduction = theFinalValueOfTheCostOfProduction;
    }

    public double getTheInitialValueOfTheCostOfProduction() {
        return theInitialValueOfTheCostOfProduction;
    }

    public void setTheInitialValueOfTheCostOfProduction(double theInitialValueOfTheCostOfProduction) {
        this.theInitialValueOfTheCostOfProduction = theInitialValueOfTheCostOfProduction;
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
