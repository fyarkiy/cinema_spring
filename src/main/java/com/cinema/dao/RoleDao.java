package com.cinema.dao;

import com.cinema.model.Role;
import com.cinema.model.RoleName;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(RoleName roleName);
}
