package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Answer;
import com.api.BankruptcyRiskAssessment.entity.Question;
import com.api.BankruptcyRiskAssessment.entity.Test;
import com.api.BankruptcyRiskAssessment.entity.TestCategory;

import java.util.List;

public interface ITestModuleService {
   /*Test Category*/
    TestCategory addTestCategory(TestCategory testCategory);

   void deleteTestCategory(Long testCategoryId);

   TestCategory getTestCategory(Long testCategoryId);

   TestCategory updateTestCategory(TestCategory testCategory);

   List<TestCategory> getAllTestCategories();

   /*Test*/
   Test addTest(Test test);

   void deleteTest(Long testId);

   Test getTest(Long testId);

   List<Test> getAllTests();

   List<Test> findTestsByTestCategory(Long testCategoryId);

   /*Questions for test*/
    Question addQuestion(Question question);

    void deleteQuestion(Long questionId);

    List<Question> findQuestionsByTest(Long testId);

    Question updateQuestion(Question question);

    /*Answers for questions*/
    Answer addAnswer(Answer answer);

    void deleteAnswersByTest(Long testId, Long userId);

    List<Answer> findAllAnswersForTest(Long testId, Long userId);

    Answer confirmAnswer(Long answerId);

    /*Calculations*/
    int calculateTestPointsForUser(Long testId, Long userId, boolean confirmed);

    int calculateDepartmentEfficiencFactory();

    int interpretEfficiencyFactory();




}
