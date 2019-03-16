package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    List<TestResult> findAllByUserId(Long userId);
    @Query("select tr from TestResult tr where tr.test.testCategory.testCategoryId = :testCategoryId and tr.user.userId = :userId")
    List<TestResult> findAllByTestCategoryId(@Param("testCategoryId") Long testCategoryId, @Param("userId") Long userId);
}
