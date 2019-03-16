package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Answer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAll(Sort sort);
    Answer findByNameIgnoreCase(String name);
    Answer findByQuestionId(Long questionId);
    List<Answer> findAllByTestIdAndUserId (Long testId, Long userId);
    List<Answer> findAllByTestIdAndUserIdAndConfirmed(Long testId, Long userId, boolean confirmed);
}
