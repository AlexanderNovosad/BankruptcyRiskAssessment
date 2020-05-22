package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Recommendation;
import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findAll(Sort sort);
    List<Recommendation> findAllByExpert(User user);
    List<Recommendation> findAllByCompany(Company company);
}
