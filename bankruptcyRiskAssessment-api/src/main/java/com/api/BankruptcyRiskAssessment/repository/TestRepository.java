package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Test;
import com.api.BankruptcyRiskAssessment.entity.TestCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findAll(Sort sort);
    Test findByNameIgnoreCase(String name);
    List<Test> findAllByTestCategory (TestCategory testCategory);

}
