package com.cinema.security;

import com.cinema.model.RoleName;
import com.cinema.model.User;
import com.cinema.service.RoleService;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);

    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService, RoleService roleService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setRoles(Set.of(roleService.getRoleByName(RoleName.CLIENT)));
        logger.info("Registration of User with e-mail " + email + " was started");
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
