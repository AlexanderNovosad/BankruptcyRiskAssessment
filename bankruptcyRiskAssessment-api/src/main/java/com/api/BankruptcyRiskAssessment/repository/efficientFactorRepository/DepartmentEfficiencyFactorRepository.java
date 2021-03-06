package com.api.BankruptcyRiskAssessment.repository.efficientFactorRepository;

import com.api.BankruptcyRiskAssessment.entity.DepartmentEfficiencyFactor;
import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentEfficiencyFactorRepository extends JpaRepository<DepartmentEfficiencyFactor, Long> {
    List<DepartmentEfficiencyFactor> findDepartmentEfficiencyFactorByDepartment_HeadOfDepartment(User headOfDepartment);
    List<DepartmentEfficiencyFactor> findDepartmentEfficiencyFactorByDepartment_Name(String departmentName);
    List<DepartmentEfficiencyFactor> findDepartmentEfficiencyFactorByDepartment_Company_CompanyName(String companyName);
}
