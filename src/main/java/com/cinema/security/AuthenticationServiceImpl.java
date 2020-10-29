package com.cinema.security;

import com.cinema.model.User;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);

    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        logger.info("Registration of User with e-mail " + email + " was started");
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
