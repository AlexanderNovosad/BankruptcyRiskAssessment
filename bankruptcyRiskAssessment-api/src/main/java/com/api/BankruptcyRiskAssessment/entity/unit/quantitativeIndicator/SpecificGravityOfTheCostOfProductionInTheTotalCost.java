package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator;

public class SpecificGravityOfTheCostOfProductionInTheTotalCost {
    String name;
    double costOfProductionForThePeriod;
    double theTotalCostForThePeriod;
    double amount;
    int point;

    public SpecificGravityOfTheCostOfProductionInTheTotalCost(String name, Double costOfProductionForThePeriod, Double theTotalCostForThePeriod){
        this.name = name;
        this.costOfProductionForThePeriod = costOfProductionForThePeriod;
        this.theTotalCostForThePeriod = theTotalCostForThePeriod;
        this.amount = costOfProductionForThePeriod/theTotalCostForThePeriod*100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostOfProductionForThePeriod() {
        return costOfProductionForThePeriod;
    }

    public void setCostOfProductionForThePeriod(double costOfProductionForThePeriod) {
        this.costOfProductionForThePeriod = costOfProductionForThePeriod;
    }

    public double getTheTotalCostForThePeriod() {
        return theTotalCostForThePeriod;
    }

    public void setTheTotalCostForThePeriod(double theTotalCostForThePeriod) {
        this.theTotalCostForThePeriod = theTotalCostForThePeriod;
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
