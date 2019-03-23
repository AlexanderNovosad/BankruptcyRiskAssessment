package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository <Department, Long> {

    Department findDepartmentByHeadOfDepartment (User headOfDepartment);
    List<Department> findAll();
    List<Department> findAllByCompany (Company company);
}
