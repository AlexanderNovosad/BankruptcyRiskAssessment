package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){ this.roleRepository = roleRepository; }

    @Override
    public Role addRole(Role role) {
        if (isNull(role)) {
            throw new EntityNotFoundException("Role is empty");
        }
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Role getRole(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException("Role not found"));
    }

    @Override
    public Role updateRole(Role role) {
        if (isNull(role)) {
            throw new EntityNotFoundException("Requested update is empty");
        }
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        Role role = this.getRole(roleId);
        roleRepository.delete(role);
    }

    @Override
    public List<Role> getAllRole() {
        List<Role> allRoles = roleRepository.findAll();
        if (allRoles.isEmpty())
            throw new EntityNotFoundException("No roles found in DB");
        return allRoles;
    }

    @Override
    public Role getRoleByName(String name){
        Role role = roleRepository.findByNameLike(name);
        if(isNull(role))
            throw new EntityNotFoundException("No matches found in DB");
        return role;
    }
}
