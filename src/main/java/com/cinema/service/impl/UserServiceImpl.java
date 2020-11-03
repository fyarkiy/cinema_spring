package com.cinema.service.impl;

import com.cinema.dao.UserDao;
import com.cinema.model.RoleName;
import com.cinema.model.User;
import com.cinema.service.RoleService;
import com.cinema.service.UserService;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder encoder;
    private final RoleService roleService;

    public UserServiceImpl(UserDao userDao, PasswordEncoder encoder, RoleService roleService) {
        this.userDao = userDao;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRoles() == null) {
            user.setRoles(Set.of(roleService.getRoleByName(RoleName.CLIENT)));
        }
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
