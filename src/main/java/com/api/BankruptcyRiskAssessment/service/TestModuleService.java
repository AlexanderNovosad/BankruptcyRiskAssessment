package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Answer;
import com.api.BankruptcyRiskAssessment.entity.Question;
import com.api.BankruptcyRiskAssessment.entity.Test;
import com.api.BankruptcyRiskAssessment.entity.TestCategory;
import com.api.BankruptcyRiskAssessment.repository.AnswerRepository;
import com.api.BankruptcyRiskAssessment.repository.QuestionRepository;
import com.api.BankruptcyRiskAssessment.repository.TestCategoryRepository;
import com.api.BankruptcyRiskAssessment.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestModuleService implements ITestModuleService {
    @Autowired
    private TestCategoryRepository testCategoryRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    /*Test Category*/
    @Override
    public TestCategory addTestCategory(TestCategory testCategory) {
        return null;
    }

    @Override
    public void deleteTestCategory(Long testCategoryId) {

    }

    @Override
    public TestCategory getTestCategory(Long testCategoryId) {
        return null;
    }

    @Override
    public TestCategory updateTestCategory(TestCategory testCategory) {
        return null;
    }

    @Override
    public List<TestCategory> getAllTestCategories() {
        return null;
    }

    /*Test*/
    @Override
    public Test addTest(Test test) {
        return null;
    }

    @Override
    public void deleteTest(Long testId) {

    }

    @Override
    public Test getTest(Long testId) {
        return null;
    }

    @Override
    public List<Test> getAllTests() {
        return null;
    }

    @Override
    public List<Test> findTestsByTestCategory(Long testCategoryId) {
        return null;
    }

    /*Questions for test*/
    @Override
    public Question addQuestion(Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(Long questionId) {

    }

    @Override
    public List<Question> findQuestionsByTest(Long testId) {
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    /*Answers for questions*/
    @Override
    public Answer addAnswer(Answer answer) {
        return null;
    }

    @Override
    public void deleteAnswersByTest(Long testId, Long userId) {

    }

    @Override
    public List<Answer> findAllAnswersForTest(Long testId, Long userId) {
        return null;
    }

    @Override
    public Answer confirmAnswer(Long answerId) {
        return null;
    }

    /*Calculations*/
    @Override
    public int calculateTestPointsForUser(Long testId, Long userId, boolean confirmed) {
        return 0;
    }

    @Override
    public int calculateDepartmentEfficiencFactory() {
        return 0;
    }

    @Override
    public int interpretEfficiencyFactory() {
        return 0;
    }
}
