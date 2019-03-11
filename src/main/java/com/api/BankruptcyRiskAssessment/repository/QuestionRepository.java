package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Question;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAll(Sort sort);
    Question findByNameIgnoreCase(String name);
    List<Question> findAllByTestId (Long testId);
    List<Question> findAllByPointsIsBetween(int firstPoint, int lastPoint);
}
