package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.*;
import com.api.BankruptcyRiskAssessment.entity.DepartmentEfficiencyFactor;
import com.api.BankruptcyRiskAssessment.entity.UserEfficiencyFactor;

import java.util.List;

public interface ITestModuleService {
   /*Test Category*/
    TestCategory addTestCategory(TestCategory testCategory);

   TestCategory deleteTestCategory(Long testCategoryId);

   TestCategory getTestCategory(Long testCategoryId);

   TestCategory updateTestCategory(TestCategory testCategory);

   List<TestCategory> getAllTestCategories();

   /*Test*/
   Test addTest(Test test);

   Test deleteTest(Long testId);

   Test getTest(Long testId);

   List<Test> getAllTests();

   List<Test> findTestsByTestCategory(Long testCategoryId);

   /*Questions for test*/
    Question addQuestion(Question question);

    Question deleteQuestion(Long questionId);

    List<Question> deleteQuestionsByTest(Long testId);

    List<Question> findQuestionsByTest(Long testId);

    Question updateQuestion(Question question);

    /*Answers for questions*/
    Answer addAnswer(Answer answer);

    List<Answer> deleteAnswersByTest(Long testId, Long userId);

    List<Answer> deleteAnswersByTest(Long testId);

    List<Answer> deleteAnswersByQuestion(Long questionId);

    List<Answer> findAllAnswersForTest(Long testId, Long userId);

    Answer confirmAnswer(Answer answer);

    /*TestResult*/
    List<TestResult> deleteTestResultByTest(Long testId);

    /*Calculations*/
    TestResult calculateTestPointsForUser(Long testId, Long userId);

    List<UserEfficiencyFactor> calculateUserEfficiencyFactory(Long userId);

    DepartmentEfficiencyFactor calculateDepartmentEfficiencyFactory(Long departmentId);

    int interpretEfficiencyFactory();




}
