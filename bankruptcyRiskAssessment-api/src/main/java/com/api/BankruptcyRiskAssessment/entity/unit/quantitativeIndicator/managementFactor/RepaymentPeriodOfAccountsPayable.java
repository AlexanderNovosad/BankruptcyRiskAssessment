package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class RepaymentPeriodOfAccountsPayable {
    String name;
    int numberOfDaysInThePeriod;
    double turnoverOfAccountsPayable;
    double amount;
    int point;

    public RepaymentPeriodOfAccountsPayable(String name, Integer numberOfDaysInThePeriod, Double turnoverOfAccountsPayable){
        this.name = name;
        this.numberOfDaysInThePeriod = numberOfDaysInThePeriod;
        this.turnoverOfAccountsPayable = turnoverOfAccountsPayable;
        this.amount = numberOfDaysInThePeriod/turnoverOfAccountsPayable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDaysInThePeriod() {
        return numberOfDaysInThePeriod;
    }

    public void setNumberOfDaysInThePeriod(int numberOfDaysInThePeriod) {
        this.numberOfDaysInThePeriod = numberOfDaysInThePeriod;
    }

    public double getTurnoverOfAccountsPayable() {
        return turnoverOfAccountsPayable;
    }

    public void setTurnoverOfAccountsPayable(double turnoverOfAccountsPayable) {
        this.turnoverOfAccountsPayable = turnoverOfAccountsPayable;
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
