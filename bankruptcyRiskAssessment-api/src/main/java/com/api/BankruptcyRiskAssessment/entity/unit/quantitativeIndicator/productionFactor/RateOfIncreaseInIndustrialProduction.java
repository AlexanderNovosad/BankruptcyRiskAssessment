package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.productionFactor;

public class RateOfIncreaseInIndustrialProduction {
    String name;
    double theUltimateValueOfProduction;
    double theInitialValueOfProduction;
    double amount;
    int point;


    public RateOfIncreaseInIndustrialProduction(String name, Double theUltimateValueOfProduction, Double theInitialValueOfProduction){
        this.name = name;
        this.theUltimateValueOfProduction = theUltimateValueOfProduction;
        this.theInitialValueOfProduction = theInitialValueOfProduction;
        this.amount = (theUltimateValueOfProduction-theInitialValueOfProduction)/theInitialValueOfProduction*100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTheUltimateValueOfProduction() {
        return theUltimateValueOfProduction;
    }

    public void setTheUltimateValueOfProduction(double theUltimateValueOfProduction) {
        this.theUltimateValueOfProduction = theUltimateValueOfProduction;
    }

    public double getTheInitialValueOfProduction() {
        return theInitialValueOfProduction;
    }

    public void setTheInitialValueOfProduction(double theInitialValueOfProduction) {
        this.theInitialValueOfProduction = theInitialValueOfProduction;
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
