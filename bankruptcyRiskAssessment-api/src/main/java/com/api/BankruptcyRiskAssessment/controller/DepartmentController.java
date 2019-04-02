package com.api.BankruptcyRiskAssessment.controller;


import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/department")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        if (isNull(department)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    @PutMapping(value = "/department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        if (isNull(department)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentService.updateDepartment(department));
    }

    @GetMapping(value = "/department")
    public ResponseEntity<Department> getDepartment(@RequestParam(value = "departmentId") Long departmentId) {
        Department department = departmentService.getDepartment(departmentId);
        if (isNull(department)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }

    @DeleteMapping(value = "/department")
    public ResponseEntity<Department> deleteDepartment(@RequestParam(value = "departmentId") Long departmentId) {
        Department department = departmentService.deleteDepartment(departmentId);
        if (isNull(department)) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }

    @GetMapping(value = "/department_list")
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.allDepartment());
    }
}
