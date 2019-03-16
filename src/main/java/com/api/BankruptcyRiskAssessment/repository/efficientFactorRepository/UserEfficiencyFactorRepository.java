package com.api.BankruptcyRiskAssessment.repository.efficientFactorRepository;

import com.api.BankruptcyRiskAssessment.entity.efficiencyFactor.UserEfficiencyFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEfficiencyFactorRepository extends JpaRepository<UserEfficiencyFactor, Long> {
    List<UserEfficiencyFactor> findUserEfficiencyFactorByUser_FirstNameAndUser_Department(String firstName, String department);
    List<UserEfficiencyFactor> findUserEfficiencyFactorByUser_Login(String userLogin);
}
