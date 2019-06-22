package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Role getRole(Long roleId) {
        Role role = roleRepository.getOne(roleId);
        if (role == null) {
            return null;
        }

        return role;
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role deleteRole(Long roleId) {
        Role role = roleRepository.getOne(roleId);
        if (role == null) {
            return null;
        }
        roleRepository.delete(role);
        return role;
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name){
        return roleRepository.findByNameLike(name);
    }
}
