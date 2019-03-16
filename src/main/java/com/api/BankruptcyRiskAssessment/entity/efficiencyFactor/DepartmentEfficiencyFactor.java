package com.api.BankruptcyRiskAssessment.entity.efficiencyFactor;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "DepartmentEfficiencyFactor")
@Table(name = "departmentEfficiencyFactor")
@EntityListeners(AuditingEntityListener.class)
public class DepartmentEfficiencyFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentEfficiencyFactorId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "departmentId", nullable = false)
    private Department department;

    @Column(nullable = false)
    private Integer efficiencyFactor;

    @Column(nullable = false)
    private Date date;

    public Long getDepartmentEfficiencyFactorId() {
        return departmentEfficiencyFactorId;
    }

    public void setDepartmentEfficiencyFactorId(Long departmentEfficiencyFactorId) {
        this.departmentEfficiencyFactorId = departmentEfficiencyFactorId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
