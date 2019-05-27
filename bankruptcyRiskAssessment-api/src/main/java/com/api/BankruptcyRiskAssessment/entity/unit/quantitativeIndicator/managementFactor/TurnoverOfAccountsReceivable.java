package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class TurnoverOfAccountsReceivable {
    String name;
    double proceedsFromSales;
    double averageAnnualValueOfAccountsReceivable;
    double amount;
    int point;

    public TurnoverOfAccountsReceivable(String name, Double proceedsFromSales, Double averageAnnualValueOfAccountsReceivable){
        this.name = name;
        this.proceedsFromSales = proceedsFromSales;
        this.averageAnnualValueOfAccountsReceivable = averageAnnualValueOfAccountsReceivable;
        this.amount = proceedsFromSales/averageAnnualValueOfAccountsReceivable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProceedsFromSales() {
        return proceedsFromSales;
    }

    public void setProceedsFromSales(double proceedsFromSales) {
        this.proceedsFromSales = proceedsFromSales;
    }

    public double getAverageAnnualValueOfAccountsReceivable() {
        return averageAnnualValueOfAccountsReceivable;
    }

    public void setAverageAnnualValueOfAccountsReceivable(double averageAnnualValueOfAccountsReceivable) {
        this.averageAnnualValueOfAccountsReceivable = averageAnnualValueOfAccountsReceivable;
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
