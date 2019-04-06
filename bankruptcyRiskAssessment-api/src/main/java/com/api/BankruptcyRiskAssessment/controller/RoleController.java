package com.api.BankruptcyRiskAssessment.controller;


import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController("/api/roles")
public class RoleController {

    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(value = "/role")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        if (isNull(role)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(roleService.addRole(role));
    }

    @PutMapping(value = "/role")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        if (isNull(role)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(roleService.updateRole(role));
    }

    @GetMapping(value = "/role")
    public ResponseEntity<Role> getRole(@RequestParam(value = "role_id") Long roleId) {
        Role role = roleService.getRole(roleId);
        if (isNull(role)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }

    @DeleteMapping(value = "/role")
    public ResponseEntity<Role> deleteRole(@RequestParam(value = "role_id") Long roleId) {
        Role role = roleService.deleteRole(roleId);
        if (isNull(role)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }

    @GetMapping(value = "/role_list")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRole());
    }

}
