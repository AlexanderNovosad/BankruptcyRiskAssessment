package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.saveAndFlush(department);
    }

    @Override
    public Department getDepartment(Long departmentId) {
        Department department = departmentRepository.getOne(departmentId);
        if (isNull(department)) {
            return null;
        }
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department deleteDepartment(Long departmentId) {
        Department department = departmentRepository.getOne(departmentId);
        if (isNull(department)) {
            return null;
        }
        // add func for delete of all department in company (except dependency of reg user)
        departmentRepository.delete(department);
        return department;
    }

    @Override
    public List<Department> allDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentForCompany(Long departmentId, Long companyId) {
        return null;
    }

    @Override
    public List<Department> allDepartmentForCompany(Company company) {
        return departmentRepository.findAllByCompany(company);
    }

    @Override
    public Department updateDepartmentForCompany(Department department, Long companyId) {
        return null;
    }

    @Override
    public Department deleteDepartmentForCompany(Long departmentId, Long companyId) {
        return null;
    }

    @Override
    public Department getDepartmentByHeadOfDepartment(User headOfDepartment) {
        Department departmentByHeadOfDepartment = departmentRepository.findDepartmentByHeadOfDepartment(headOfDepartment);
        if (isNull(departmentByHeadOfDepartment)) {
            return null;
        }
        return departmentByHeadOfDepartment;
    }
}
