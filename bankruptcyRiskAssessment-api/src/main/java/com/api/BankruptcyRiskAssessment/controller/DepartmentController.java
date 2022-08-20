package com.api.BankruptcyRiskAssessment.controller;


import com.api.BankruptcyRiskAssessment.entity.Department;
import com.api.BankruptcyRiskAssessment.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final IDepartmentService departmentService;

    @Autowired
    public DepartmentController(IDepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/department")
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(department));
    }

    @PutMapping(value = "/department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.updateDepartment(department));
    }

    @GetMapping(value = "/department")
    public ResponseEntity<Department> getDepartment(@RequestParam(value = "departmentId") Long departmentId) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartment(departmentId));
    }

    @DeleteMapping(value = "/department")
    public ResponseEntity deleteDepartment(@RequestParam(value = "departmentId") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.OK).body("delete completed successfully");
    }

    @GetMapping(value = "/department_list")
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDepartments());
    }
}
