package com.prime.task.prime.service;

import com.prime.task.prime.model.Role;

public interface RoleService {
    Role findByName(String name);
}