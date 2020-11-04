package com.cinema.service;

import com.cinema.model.Role;
import com.cinema.model.RoleName;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(RoleName roleName);
}
