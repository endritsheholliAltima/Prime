package com.prime.task.prime.service;

import com.prime.task.prime.model.Role;
import com.prime.task.prime.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        Role role = roleRepository.findRoleByName(name);
        return role;
    }
}