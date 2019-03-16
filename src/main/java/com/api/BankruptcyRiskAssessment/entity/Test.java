package com.api.BankruptcyRiskAssessment.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity(name = "Test")
@Table(name = "test")
@EntityListeners(AuditingEntityListener.class)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long testId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "testCategoryId", nullable = false)
    private TestCategory testCategory;

    @Column(nullable = false)
    private String name;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public TestCategory getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(TestCategory testCategory) {
        this.testCategory = testCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
