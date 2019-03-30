package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.*;
import com.api.BankruptcyRiskAssessment.service.ITestModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/testModule")
public class TestModuleController {
    @Autowired
    private ITestModuleService testModuleService;

    /*Test Category*/
    @PostMapping("/testCategory")
    public ResponseEntity<TestCategory> addTestCategory(@RequestBody TestCategory testCategory){
        if(testCategory==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testModuleService.addTestCategory(testCategory));
    }

    @DeleteMapping("/testCategory")
    public ResponseEntity<TestCategory> deleteTestCategory(@RequestParam(value = "testCategory_id") Long testCategoryId){
        TestCategory testCategory = testModuleService.deleteTestCategory(testCategoryId);
        if(testCategory==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(testCategory);
    }

    @GetMapping("/testCategory")
    public ResponseEntity<TestCategory> getTestCategory(@RequestParam(value = "testCategory_id") Long testCategoryId){
        TestCategory testCategory = testModuleService.getTestCategory(testCategoryId);
        if(testCategory==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testCategory);
    }

    @PutMapping("/testCategory")
    public ResponseEntity<TestCategory> updateTestCategory(@RequestBody TestCategory testCategory){
        if(testCategory==null){
            return ResponseEntity.badRequest().build();
        }
        testModuleService.updateTestCategory(testCategory);
        return ResponseEntity.ok(testCategory);
    }

    @GetMapping("/testCategories")
    public ResponseEntity<List<TestCategory>> getAllTestCategories(){
        if (testModuleService.getAllTestCategories() == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testModuleService.getAllTestCategories());
    }

    /*Test*/
    @PostMapping("/test")
    public ResponseEntity<Test> addTest(@RequestBody Test test){
        if(test == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(testModuleService.addTest(test));
    }

    @DeleteMapping("/test")
    public ResponseEntity<Test> deleteTest(@RequestParam(value = "test_id") Long testId){
        Test test = testModuleService.deleteTest(testId);
        if(test==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(test);
    }

    @GetMapping("/test")
    public ResponseEntity<Test> getTest(@RequestParam(value = "test_id") Long testId){
        Test test = testModuleService.getTest(testId);
        if(test==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(test);
    }

    @GetMapping("/tests")
    public ResponseEntity<List<Test>> getAllTests(){
        return ResponseEntity.ok(testModuleService.getAllTests());
    }

    @GetMapping("/testCategory/tests")
    public ResponseEntity<List<Test>> findTestsByTestCategory(@RequestParam(value = "testCategory_id") Long testCategoryId){
        List<Test> tests = testModuleService.findTestsByTestCategory(testCategoryId);
        if (tests==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tests);
    }

    /*Questions for test*/
    @PostMapping("/question")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        if(question == null){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(testModuleService.addQuestion(question));
    }

    @DeleteMapping("/question")
    public ResponseEntity<Question> deleteQuestion(@RequestParam(value = "question_id") Long questionId){
        Question question = testModuleService.deleteQuestion(questionId);
        if(question==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(question);
    }

    @DeleteMapping("/test/questions")
    public ResponseEntity<List<Question>> deleteQuestionsByTest(@RequestParam(value = "test_id") Long testId){
        List<Question> questions = testModuleService.deleteQuestionsByTest(testId);
        if(questions==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/test/questions")
    public ResponseEntity<List<Question>> findQuestionsByTest(@RequestParam(value = "test_id") Long testId){
        List<Question> questions = testModuleService.findQuestionsByTest(testId);
        if(questions==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/question")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        if(question==null){
            return ResponseEntity.badRequest().build();
        }
        testModuleService.updateQuestion(question);
        return ResponseEntity.ok(question);
    }

    /*Answers for questions*/
    @PostMapping("/answer")
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer){
        if(answer == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(testModuleService.addAnswer(answer));
    }

    @DeleteMapping("user/test/answers")
    public ResponseEntity<List<Answer>> deleteAnswersByTest(@RequestParam(value = "test_id") Long testId, @RequestParam(value = "user_id") Long userId){
        List<Answer> answers = testModuleService.deleteAnswersByTest(testId, userId);
        if (answers==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(answers);
    }

    @DeleteMapping("/test/answers")
    public ResponseEntity<List<Answer>> deleteAnswersByTest(@RequestParam(value = "test_id") Long testId){
        List<Answer> answers = testModuleService.deleteAnswersByTest(testId);
        if (answers==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(answers);
    }

    @DeleteMapping("/question/answers")
    public ResponseEntity<List<Answer>> deleteAnswersByQuestion(@RequestParam(value = "question_id") Long questionId){
        List<Answer> answers = testModuleService.deleteAnswersByQuestion(questionId);
        if (answers==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(answers);
    }

    @GetMapping("user/test/answers")
    public ResponseEntity<List<Answer>> findAllAnswersForTest(@RequestParam(value = "test_id") Long testId, @RequestParam(value = "user_id") Long userId){
        List<Answer> answers = testModuleService.findAllAnswersForTest(testId, userId);
        if (answers==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(answers);
    }

    @PutMapping("/answer")
    public ResponseEntity<Answer> confirmAnswer(@RequestBody Answer answer){
        if(answer == null){
            return ResponseEntity.badRequest().build();
        }
        testModuleService.confirmAnswer(answer);
        return ResponseEntity.ok(answer);
    }

    /*TestResult*/
    @DeleteMapping("/test/testResult")
    public ResponseEntity<List<TestResult>> deleteTestResultByTest(@RequestParam(value = "test_id") Long testId){
        List<TestResult> testResults = testModuleService.deleteTestResultByTest(testId);
        if(testResults==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(testResults);
    }

    /*Calculations*/
    @PostMapping("user/test/testResult")
    public ResponseEntity<TestResult> calculateTestPointsForUser(@RequestParam(value = "test_id") Long testId, @RequestParam(value = "user_id") Long userId){
        TestResult testResult = testModuleService.calculateTestPointsForUser(testId, userId);
        if(testResult==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(testResult);
    }

    @PostMapping("user/userEfficiencyFactory")
    public ResponseEntity<List<UserEfficiencyFactor>> calculateUserEfficiencyFactory(@RequestParam(value = "user_id") Long userId){
        List<UserEfficiencyFactor> userEfficiencyFactors = testModuleService.calculateUserEfficiencyFactory(userId);
        if(userEfficiencyFactors==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userEfficiencyFactors);
    }

    @PostMapping("department/departmentEfficiencyFactory")
    public ResponseEntity<DepartmentEfficiencyFactor> calculateDepartmentEfficiencyFactory(@RequestParam(value = "department_id") Long departmentId){
        DepartmentEfficiencyFactor departmentEfficiencyFactor = testModuleService.calculateDepartmentEfficiencyFactory(departmentId);
        if(departmentEfficiencyFactor==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(departmentEfficiencyFactor);
    }


}
