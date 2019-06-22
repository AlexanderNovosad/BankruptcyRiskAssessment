package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Role;

import java.util.List;

public interface IRoleService {

    Role addRole(Role role);

    Role getRole(Long roleId);

    Role updateRole(Role role);

    Role deleteRole(Long roleId);

    List<Role> getAllRole();

    Role getRoleByName(String name);
}
