package com.api.BankruptcyRiskAssessment.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "UniversalDiscriminatoryModel")
@Table(name = "universalDiscriminatoryModel")
@EntityListeners(AuditingEntityListener.class)
public class UniversalDiscriminatoryModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long universalDiscriminatoryId;

    @Column(nullable = false)
    private Double z;

    @Column(nullable = false)
    private Double x1;

    @Column(nullable = false)
    private Double x2;

    @Column(nullable = false)
    private Double x3;

    @Column(nullable = false)
    private Double x4;

    @Column(nullable = false)
    private Double x5;

    @Column(nullable = false)
    private Double x6;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    UniversalDiscriminatoryModel(){}

    public UniversalDiscriminatoryModel(double z, double x1, double x2, double x3, double x4, double x5, double x6, Company company){
        this.z = z;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.x6 = x6;
        this.company = company;
        this.date = new Date(System.currentTimeMillis());
    }

    public Long getUniversalDiscriminatoryModelId() {
        return universalDiscriminatoryId;
    }

    public void setUniversalDiscriminatoryModelId(Long universalDiscriminatoryId) {
        this.universalDiscriminatoryId = universalDiscriminatoryId;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public Double getX3() {
        return x3;
    }

    public void setX3(Double x3) {
        this.x3 = x3;
    }

    public Double getX4() {
        return x4;
    }

    public void setX4(Double x4) {
        this.x4 = x4;
    }

    public Double getX5() {
        return x5;
    }

    public void setX5(Double x5) {
        this.x5 = x5;
    }

    public Double getX6() {
        return x6;
    }

    public void setX6(Double x6) {
        this.x6 = x6;
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
}
