package com.api.BankruptcyRiskAssessment.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "TestCategory")
@Table(name = "testCategory")
@EntityListeners(AuditingEntityListener.class)
public class TestCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long testCategoryId;

    @Column(nullable = false)
    private String name;

    public Long getTestCategoryId() {
        return testCategoryId;
    }

    public void setTestCategoryId(Long testCategoryId) {
        this.testCategoryId = testCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestCategory(){}
}
