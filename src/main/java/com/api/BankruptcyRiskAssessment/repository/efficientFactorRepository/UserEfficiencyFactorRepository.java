package com.api.BankruptcyRiskAssessment.repository.efficientFactorRepository;

import com.api.BankruptcyRiskAssessment.entity.UserEfficiencyFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserEfficiencyFactorRepository extends JpaRepository<UserEfficiencyFactor, Long> {
    List<UserEfficiencyFactor> findUserEfficiencyFactorByUser_FirstNameAndUser_Department(String firstName, String department);
    List<UserEfficiencyFactor> findUserEfficiencyFactorByUser_Login(String userLogin);
    @Query("select uef from UserEfficiencyFactor uef where uef.user.department.departmentId = :departmentId")
    List<UserEfficiencyFactor> findAllByDepartmentId(@Param("departmentId") Long departmentId);
}
