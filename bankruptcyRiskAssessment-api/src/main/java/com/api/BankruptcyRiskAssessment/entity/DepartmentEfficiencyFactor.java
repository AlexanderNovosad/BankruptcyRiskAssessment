package com.api.BankruptcyRiskAssessment.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "DepartmentEfficiencyFactor")
@Table(name = "departmentEfficiencyFactor")
@EntityListeners(AuditingEntityListener.class)
public class DepartmentEfficiencyFactor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentEfficiencyFactorId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "departmentId", nullable = false)
    private Department department;

    @Column(nullable = false)
    private Integer efficiencyFactor;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getDepartmentEfficiencyFactorId() {
        return departmentEfficiencyFactorId;
    }

    public void setDepartmentEfficiencyFactorId(Long departmentEfficiencyFactorId) {
        this.departmentEfficiencyFactorId = departmentEfficiencyFactorId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEfficiencyFactor() {
        return efficiencyFactor;
    }

    public void setEfficiencyFactor(Integer efficiencyFactor) {
        this.efficiencyFactor = efficiencyFactor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
