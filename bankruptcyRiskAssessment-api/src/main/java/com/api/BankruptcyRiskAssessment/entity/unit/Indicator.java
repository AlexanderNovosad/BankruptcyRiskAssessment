package com.api.BankruptcyRiskAssessment.entity.unit;

public class Indicator {
    private String name;
    private LinguisticAssessment assessment;
    private Factor factor;

    public Indicator(String name, Factor factor){
        this.name = name;
        this.factor = factor;
        this.setAssessment(new LinguisticAssessment());
    }

    public Indicator(){}

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

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }
}
