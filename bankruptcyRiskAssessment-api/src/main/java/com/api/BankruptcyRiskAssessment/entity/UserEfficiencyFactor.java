package com.api.BankruptcyRiskAssessment.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity(name = "UserEfficiencyFactor")
@Table(name = "userEfficiencyFactor")
@EntityListeners(AuditingEntityListener.class)
public class UserEfficiencyFactor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userEfficiencyFactorId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "testCategoryId", nullable = false)
    private TestCategory testCategory;

    @Column(nullable = false)
    private Integer efficiencyFactor;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public UserEfficiencyFactor(){}

    public Long getUserEfficiencyFactorId() {
        return userEfficiencyFactorId;
    }

    public void setUserEfficiencyFactorId(Long userEfficiencyFactorId) {
        this.userEfficiencyFactorId = userEfficiencyFactorId;
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
