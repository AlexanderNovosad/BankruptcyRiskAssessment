package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class RepaymentPeriodOfAccountsReceivable {
    String name;
    int numberOfDaysInThePeriod;
    double turnoverOfAccountsReceivable;
    double amount;
    int point;

    public RepaymentPeriodOfAccountsReceivable(String name, Integer numberOfDaysInThePeriod, Double turnoverOfAccountsReceivable){
        this.name = name;
        this.numberOfDaysInThePeriod = numberOfDaysInThePeriod;
        this.turnoverOfAccountsReceivable = turnoverOfAccountsReceivable;
        this.amount = numberOfDaysInThePeriod/turnoverOfAccountsReceivable;
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

    public double getTurnoverOfAccountsReceivable() {
        return turnoverOfAccountsReceivable;
    }

    public void setTurnoverOfAccountsReceivable(double turnoverOfAccountsReceivable) {
        this.turnoverOfAccountsReceivable = turnoverOfAccountsReceivable;
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
