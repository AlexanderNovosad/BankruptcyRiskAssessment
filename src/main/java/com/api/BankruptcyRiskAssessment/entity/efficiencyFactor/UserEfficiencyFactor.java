package com.api.BankruptcyRiskAssessment.entity.efficiencyFactor;

import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.entity.TestCategory;
import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;



@Entity(name = "UserEfficiencyFactor")
@Table(name = "userEfficiencyFactor")
@EntityListeners(AuditingEntityListener.class)
public class UserEfficiencyFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userEfficiencyFactorId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "departmentId", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "testCategoryId", nullable = false)
    private TestCategory testCategory;

    @Column(nullable = false)
    private Integer efficiencyFactor;

    @Column(nullable = false)
    private Date date;

    public Long getUserEfficiencyFactorId() {
        return userEfficiencyFactorId;
    }

    public void setUserEfficiencyFactorId(Long userEfficiencyFactorId) {
        this.userEfficiencyFactorId = userEfficiencyFactorId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TestCategory getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(TestCategory testCategory) {
        this.testCategory = testCategory;
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
