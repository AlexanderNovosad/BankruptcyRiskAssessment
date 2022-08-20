package com.api.BankruptcyRiskAssessment.controller;


import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping(value = "/role")
    public ResponseEntity<Role> addRole(@Valid @RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.addRole(role));
    }

    @PutMapping(value = "/role")
    public ResponseEntity<Role> updateRole(@Valid @RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.updateRole(role));
    }

    @GetMapping(value = "/role")
    public ResponseEntity<Role> getRole(@RequestParam(value = "role_id") Long roleId) {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getRole(roleId));
    }

    @DeleteMapping(value = "/role")
    public ResponseEntity deleteRole(@RequestParam(value = "role_id") Long roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.status(HttpStatus.OK).body("delete completed successfully");
    }

    @GetMapping(value = "/role_list")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getAllRole());
    }

}
