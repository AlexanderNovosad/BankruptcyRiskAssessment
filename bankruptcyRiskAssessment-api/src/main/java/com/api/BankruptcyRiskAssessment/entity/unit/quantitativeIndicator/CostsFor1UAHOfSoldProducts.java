package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator;

public class CostsFor1UAHOfSoldProducts {
    String name;
    double netIncomeFromSales;
    double costOfSales;
    double amount;
    int point;

    public CostsFor1UAHOfSoldProducts(String name, Double netIncomeFromSales, Double costOfSales){
        this.name = name;
        this.netIncomeFromSales = netIncomeFromSales;
        this.costOfSales = costOfSales;
        this.amount = netIncomeFromSales/costOfSales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNetIncomeFromSales() {
        return netIncomeFromSales;
    }

    public void setNetIncomeFromSales(double netIncomeFromSales) {
        this.netIncomeFromSales = netIncomeFromSales;
    }

    public double getCostOfSales() {
        return costOfSales;
    }

    public void setCostOfSales(double costOfSales) {
        this.costOfSales = costOfSales;
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
