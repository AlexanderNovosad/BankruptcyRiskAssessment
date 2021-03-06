package com.api.BankruptcyRiskAssessment.entity.unit;

public class Factor {
    private String name;
    private LinguisticAssessment assessment;
    private double assessmentPoint;

    public Factor(String name){this.name = name;}

    public Factor(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinguisticAssessment getAssessment() {
        return assessment;
    }

    public void setAssessment(LinguisticAssessment assessment) {
        this.assessment = assessment;
    }

    public double getAssessmentPoint() {
        return assessmentPoint;
    }

    public void setAssessmentPoint(double assessmentPoint) {
        this.assessmentPoint = assessmentPoint;
    }
}
