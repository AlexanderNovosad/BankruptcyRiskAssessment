package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Company;
import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(Department department) {
        if (isNull(department)) {
            throw new EntityNotFoundException("Department is empty");
        }
        return departmentRepository.saveAndFlush(department);
    }

    @Override
    public Department getDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department not found"));
    }

    @Override
    public Department updateDepartment(Department department) {
        if (isNull(department)) {
            throw new EntityNotFoundException("Requested update is empty");
        }
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = this.getDepartment(departmentId);
        departmentRepository.delete(department);
    }

    @Override
    public void deleteDepartmentsByCompany(Company company) {
        List<Department> departments = departmentRepository.findAllByCompany(company);
        if (!departments.isEmpty()) {
            departmentRepository.deleteAll(departments);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.findAll();
        if (allDepartments.isEmpty())
            throw new EntityNotFoundException("No departments found in DB");
        return allDepartments;
    }

    @Override
    public List<Department> allDepartmentForCompany(Company company) {
        List<Department> departments = departmentRepository.findAllByCompany(company);
        if (departments.isEmpty()) {
            throw new EntityNotFoundException("No departments found by this company");
        }
        return departments;
    }

    @Override
    public Department getDepartmentByHeadOfDepartment(User headOfDepartment) {
        Department departmentByHeadOfDepartment = departmentRepository.findDepartmentByHeadOfDepartment(headOfDepartment);
        if (isNull(departmentByHeadOfDepartment)) {
            throw new EntityNotFoundException("This user doesn't manage any department");
        }
        return departmentByHeadOfDepartment;
    }
}
