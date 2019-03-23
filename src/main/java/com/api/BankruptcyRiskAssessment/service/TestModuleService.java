package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.*;
import com.api.BankruptcyRiskAssessment.entity.DepartmentEfficiencyFactor;
import com.api.BankruptcyRiskAssessment.entity.UserEfficiencyFactor;
import com.api.BankruptcyRiskAssessment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private TestResultRepository testResultRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserEfficiencyFactorRepository userEfficiencyFactorRepository;
    @Autowired
    private DepartmentEfficiencyFactorRepository departmentEfficiencyFactorRepository;

    /*Test Category*/
    @Override
    public TestCategory addTestCategory(TestCategory testCategory) {
        return testCategoryRepository.saveAndFlush(testCategory);
    }

    @Override
    public TestCategory deleteTestCategory(Long testCategoryId) {
        TestCategory testCategory = testCategoryRepository.getOne(testCategoryId);
        if(testCategory == null){
            return null;
        }
        List<Test> tests = testRepository.findAllByTestCategory(testCategory);
        tests.forEach(test -> test.setTestCategory(null));
        testCategoryRepository.delete(testCategory);
        return testCategory;
    }

    @Override
    public TestCategory getTestCategory(Long testCategoryId) {
        TestCategory testCategory = testCategoryRepository.getOne(testCategoryId);
        if(testCategory == null){
            return null;
        }
        return testCategory;
    }

    @Override
    public TestCategory updateTestCategory(TestCategory testCategory) {
        return testCategoryRepository.save(testCategory);
    }

    @Override
    public List<TestCategory> getAllTestCategories() {
        return testCategoryRepository.findAll();
    }

    /*Test*/
    @Override
    public Test addTest(Test test) {
        return testRepository.saveAndFlush(test);
    }

    @Override
    public Test deleteTest(Long testId) {
        Test test = testRepository.getOne(testId);
        if(test == null){
            return null;
        }
        deleteAnswersByTest(testId);
        deleteQuestionsByTest(testId);
        deleteTestResultByTest(testId);
        testRepository.delete(test);
        return test;
    }

    @Override
    public Test getTest(Long testId) {
        Test test = testRepository.getOne(testId);
        if(test == null){
            return null;
        }
        return test;
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public List<Test> findTestsByTestCategory(Long testCategoryId) {
        TestCategory testCategory = testCategoryRepository.getOne(testCategoryId);
        if(testCategory == null){
            return null;
        }
        List<Test> tests = testRepository.findAllByTestCategory(testCategory);
        return tests;
    }

    /*Questions for test*/
    @Override
    public Question addQuestion(Question question) {
        return questionRepository.saveAndFlush(question);
    }

    @Override
    public Question deleteQuestion(Long questionId) {
        Question question = questionRepository.getOne(questionId);
        if(question == null){
            return null;
        }
        deleteAnswersByQuestion(questionId);
        questionRepository.delete(question);
        return question;
    }

    @Override
    public List<Question> deleteQuestionsByTest(Long testId) {
        Test test =  testRepository.getOne(testId);
        if(test == null){
            return null;
        }
        List<Question> questions = questionRepository.findAllByTest(test);
        questionRepository.deleteAll(questions);
        return questions;
    }

    @Override
    public List<Question> findQuestionsByTest(Long testId) {
        Test test =  testRepository.getOne(testId);
        if(test == null){
            return null;
        }
        return questionRepository.findAllByTest(test);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    /*Answers for questions*/
    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepository.saveAndFlush(answer);
    }

    @Override
    public List<Answer> deleteAnswersByTest(Long testId, Long userId) {
        Test test = testRepository.getOne(testId);
        User user = userRepository.getOne(userId);
        if(test==null || user==null){
            return null;
        }
        List<Answer> answers = answerRepository.findAllByTestAndUser(test, user);
        answerRepository.deleteAll(answers);
        return answers;
    }

    @Override
    public List<Answer> deleteAnswersByTest(Long testId) {
        Test test = testRepository.getOne(testId);
        if(test==null){
            return null;
        }
        List<Answer> answers = answerRepository.findAllByTest(test);
        answerRepository.deleteAll(answers);
        return answers;
    }

    @Override
    public List<Answer> deleteAnswersByQuestion(Long questionId) {
        Question question = questionRepository.getOne(questionId);
        if(question==null){
            return null;
        }
        List<Answer> answers = answerRepository.findAllByQuestion(question);
        answerRepository.deleteAll(answers);
        return answers;
    }

    @Override
    public List<Answer> findAllAnswersForTest(Long testId, Long userId) {
        Test test = testRepository.getOne(testId);
        User user = userRepository.getOne(userId);
        if(test==null || user==null){
            return null;
        }
        return answerRepository.findAllByTestAndUser(test, user);
    }

    @Override
    public Answer confirmAnswer(Answer answer) {
        answer.setConfirmed(true);
        return answerRepository.save(answer);
    }

    /*TestResult*/
    @Override
    public List<TestResult> deleteTestResultByTest(Long testId){
        Test test = testRepository.getOne(testId);
        if(test==null){
            return null;
        }
        List<TestResult> testResults = testResultRepository.findAllByTest(test);
        testResultRepository.deleteAll(testResults);
        return testResults;
    }


    /*Calculations*/
    @Override
    public TestResult calculateTestPointsForUser(Long testId, Long userId) {
        Test test = testRepository.getOne(testId);
        User user = userRepository.getOne(userId);
        if(test==null || user==null){
            return null;
        }
        TestResult testResult = new TestResult(test, user);
        List<Answer> answers = answerRepository.findAllByTestAndUserAndConfirmedTrue(test, user);
        answers.forEach(answer -> testResult.setPoints(testResult.getPoints() + answer.getQuestion().getPoints()));
        return testResultRepository.saveAndFlush(testResult);
    }

    @Override
    public List<UserEfficiencyFactor> calculateUserEfficiencyFactory(Long userId){
        List<TestCategory> testCategories = testCategoryRepository.findAll();
        List<UserEfficiencyFactor> userEfficiencyFactors = new ArrayList<UserEfficiencyFactor>();
        for(int i=0; i<testCategories.size(); i++){
            UserEfficiencyFactor userEfficiencyFactor = new UserEfficiencyFactor();
            userEfficiencyFactor.setUser(userRepository.getOne(userId));
            userEfficiencyFactor.setDate(new java.sql.Date(System.currentTimeMillis()));
            testResultRepository.findAllByTestCategoryId(testCategories.get(i).getTestCategoryId(), userId).forEach(testResult ->
            userEfficiencyFactor.setEfficiencyFactor(userEfficiencyFactor.getEfficiencyFactor()+testResult.getPoints()));
            userEfficiencyFactors.add(userEfficiencyFactor);
        }
        userEfficiencyFactors.forEach(userEfficiencyFactor -> userEfficiencyFactorRepository.saveAndFlush(userEfficiencyFactor));

        return userEfficiencyFactors;
    }

    @Override
    public DepartmentEfficiencyFactor calculateDepartmentEfficiencyFactory(Long departmentId) {
        List<UserEfficiencyFactor> userEfficiencyFactors = userEfficiencyFactorRepository.findAllByDepartmentId();
        DepartmentEfficiencyFactor departmentEfficiencyFactor = new DepartmentEfficiencyFactor();
        departmentEfficiencyFactor.setDepartment(departmentRepository.getOne(departmentId));
        departmentEfficiencyFactor.setDate(new java.sql.Date(System.currentTimeMillis()));
        userEfficiencyFactors.forEach(userEfficiencyFactor -> departmentEfficiencyFactor.setEfficiencyFactor(departmentEfficiencyFactor.getEfficiencyFactor()+userEfficiencyFactor.getEfficiencyFactor()));
        departmentEfficiencyFactor.setEfficiencyFactor(departmentEfficiencyFactor.getEfficiencyFactor()/userEfficiencyFactors.size());
        return departmentEfficiencyFactorRepository.saveAndFlush(departmentEfficiencyFactor);
    }

    @Override
    public int interpretEfficiencyFactory() {
        return 0;
    }
}
