package com.api.BankruptcyRiskAssessment.entity.unit;

import java.util.List;

public class InDataForSetTheAssessments {
    private List<Indicator> indicators;
    private List<LinguisticAssessment> assessments;

    InDataForSetTheAssessments(){}

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }

    public List<LinguisticAssessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<LinguisticAssessment> assessments) {
        this.assessments = assessments;
    }
}
