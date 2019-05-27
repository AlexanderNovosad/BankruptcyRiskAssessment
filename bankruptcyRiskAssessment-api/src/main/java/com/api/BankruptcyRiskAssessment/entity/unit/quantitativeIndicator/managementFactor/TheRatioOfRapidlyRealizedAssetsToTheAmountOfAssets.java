package com.api.BankruptcyRiskAssessment.entity.unit.quantitativeIndicator.managementFactor;

public class TheRatioOfRapidlyRealizedAssetsToTheAmountOfAssets {
    String name;
    double rapidlyRealizedAssets;
    double amountOfAssets;
    double amount;
    int point;

    public TheRatioOfRapidlyRealizedAssetsToTheAmountOfAssets(String name, Double rapidlyRealizedAssets, Double amountOfAssets){
        this.name = name;
        this.rapidlyRealizedAssets = rapidlyRealizedAssets;
        this.amountOfAssets = amountOfAssets;
        this.amount = rapidlyRealizedAssets/amountOfAssets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRapidlyRealizedAssets() {
        return rapidlyRealizedAssets;
    }

    public void setRapidlyRealizedAssets(double rapidlyRealizedAssets) {
        this.rapidlyRealizedAssets = rapidlyRealizedAssets;
    }

    public double getAmountOfAssets() {
        return amountOfAssets;
    }

    public void setAmountOfAssets(double amountOfAssets) {
        this.amountOfAssets = amountOfAssets;
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
