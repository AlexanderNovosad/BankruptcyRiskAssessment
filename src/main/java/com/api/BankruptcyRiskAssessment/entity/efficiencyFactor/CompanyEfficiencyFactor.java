package com.api.BankruptcyRiskAssessment.entity.efficiencyFactor;

import com.api.BankruptcyRiskAssessment.entity.Company;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;


@Entity(name = "CompanyEfficiencyFactor")
@Table (name = "companyEfficiencyFactor")
@EntityListeners(AuditingEntityListener.class)
public class CompanyEfficiencyFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyEfficiencyFactorId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @Column(nullable = false)
    private Integer efficiencyFactor;

    @Column(nullable = false)
    private Date date;

    public Long getCompanyEfficiencyFactorId() {
        return companyEfficiencyFactorId;
    }

    public void setCompanyEfficiencyFactorId(Long companyEfficiencyFactorId) {
        this.companyEfficiencyFactorId = companyEfficiencyFactorId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
