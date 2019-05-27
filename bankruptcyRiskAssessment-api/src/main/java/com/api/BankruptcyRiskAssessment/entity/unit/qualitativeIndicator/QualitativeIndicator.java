package com.api.BankruptcyRiskAssessment.entity.unit.qualitativeIndicator;

public abstract class QualitativeIndicator {
    String name;
    int point;

    public QualitativeIndicator(String name, Integer point){
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
