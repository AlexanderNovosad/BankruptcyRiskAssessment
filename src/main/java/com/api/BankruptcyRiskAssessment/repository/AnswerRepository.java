package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Answer;
import com.api.BankruptcyRiskAssessment.entity.Question;
import com.api.BankruptcyRiskAssessment.entity.Test;
import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAll(Sort sort);
    Answer findByQuestion(Question question);
    List<Answer> findAllByTestAndUser (Test test, User user);
    List<Answer> findAllByTestAndUserAndConfirmedTrue(Test test, User user);
}
