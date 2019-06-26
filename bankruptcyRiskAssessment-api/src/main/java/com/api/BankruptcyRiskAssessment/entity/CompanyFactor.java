package com.api.BankruptcyRiskAssessment.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "CompanyFactor")
@Table(name = "NedosekinModel")
@EntityListeners(AuditingEntityListener.class)
public class CompanyFactor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyFactorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String linguisticAssessment;

    @Column(nullable = false)
    private Double assessmentPoint;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public CompanyFactor(){}

    public CompanyFactor(String name, String linguisticAssessment, double assessmentPoint, Company company){
        this.name = name;
        this.linguisticAssessment = linguisticAssessment;
        this.assessmentPoint = assessmentPoint;
        this.company = company;
        this.date = new Date(System.currentTimeMillis());
    }


    public Long getCompanyFactorId() {
        return companyFactorId;
    }

    public void setCompanyFactorId(Long companyFactorId) {
        this.companyFactorId = companyFactorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinguisticAssessment() {
        return linguisticAssessment;
    }

    public void setLinguisticAssessment(String linguisticAssessment) {
        this.linguisticAssessment = linguisticAssessment;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAssessmentPoint() {
        return assessmentPoint;
    }

    public void setAssessmentPoint(Double assessmentPoint) {
        this.assessmentPoint = assessmentPoint;
    }
}
