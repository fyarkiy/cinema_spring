package com.cinema.util;

import com.cinema.dao.UserDao;
import com.cinema.model.Role;
import com.cinema.model.RoleName;
import com.cinema.model.User;
import com.cinema.service.RoleService;
import com.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;
    private final UserDao userDao;

    public InjectData(UserService userService, RoleService roleService,
                      PasswordEncoder encoder, UserDao userDao) {
        this.userService = userService;
        this.roleService = roleService;
        this.encoder = encoder;
        this.userDao = userDao;
    }

    @PostConstruct
    private void postConstruct() {
        roleService.add(new Role(RoleName.CLIENT));
        roleService.add(new Role(RoleName.ADMIN));
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        admin.setRoles(Set.of(roleService.getRoleByName(RoleName.ADMIN)));
        userService.add(admin);
    }
}
