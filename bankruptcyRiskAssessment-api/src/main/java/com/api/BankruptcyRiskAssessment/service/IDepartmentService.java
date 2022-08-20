package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.entity.User;

import java.util.List;

public interface IDepartmentService {

    Department addDepartment(Department department);

    Department getDepartment(Long departmentId);

    Department updateDepartment(Department department);

    void deleteDepartment(Long departmentId);

    void deleteDepartmentsByCompany(Company company);

    List<Department> getAllDepartments();

    List<Department> allDepartmentForCompany(Company company);

    Department getDepartmentByHeadOfDepartment (User headOfDepartment);
}
