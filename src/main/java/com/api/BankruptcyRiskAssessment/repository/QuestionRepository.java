package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Question;
import com.api.BankruptcyRiskAssessment.entity.Test;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAll(Sort sort);
    List<Question> findAllByTest (Test test);
    List<Question> findAllByPointsIsBetween(int firstPoint, int lastPoint);
}
