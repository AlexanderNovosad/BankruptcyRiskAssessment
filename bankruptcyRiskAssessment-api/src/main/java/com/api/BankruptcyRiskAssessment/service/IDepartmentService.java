package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.entity.User;

import java.util.List;

public interface IDepartmentService {

    Department addDepartment(Department department);

    Department getDepartment(Long departmentId);

    Department updateDepartment(Department department);

    Department deleteDepartment(Long departmentId);

    List<Department> allDepartment();

    Department getDepartmentForCompany(Long departmentId, Long companyId);

    List<Department> allDepartmentForCompany(Company company);

    Department updateDepartmentForCompany(Department department, Long companyId);

    Department deleteDepartmentForCompany(Long departmentId, Long companyId);

    Department getDepartmentByHeadOfDepartment (User headOfDepartment);
}
