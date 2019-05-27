package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class DurationOfTheOperatingCycle {
    String name;
    double repaymentPeriodOfAccountsReceivable;
    double periodOfTurnoverOfInventories;
    double amount;
    int point;

    public DurationOfTheOperatingCycle(String name, Double repaymentPeriodOfAccountsReceivable, Double periodOfTurnoverOfInventories){
        this.name = name;
        this.repaymentPeriodOfAccountsReceivable = repaymentPeriodOfAccountsReceivable;
        this.periodOfTurnoverOfInventories = periodOfTurnoverOfInventories;
        this.amount = repaymentPeriodOfAccountsReceivable + periodOfTurnoverOfInventories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRepaymentPeriodOfAccountsReceivable() {
        return repaymentPeriodOfAccountsReceivable;
    }

    public void setRepaymentPeriodOfAccountsReceivable(double repaymentPeriodOfAccountsReceivable) {
        this.repaymentPeriodOfAccountsReceivable = repaymentPeriodOfAccountsReceivable;
    }

    public double getPeriodOfTurnoverOfInventories() {
        return periodOfTurnoverOfInventories;
    }

    public void setPeriodOfTurnoverOfInventories(double periodOfTurnoverOfInventories) {
        this.periodOfTurnoverOfInventories = periodOfTurnoverOfInventories;
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
