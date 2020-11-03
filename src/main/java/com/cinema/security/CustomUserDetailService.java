package com.cinema.security;

import com.cinema.model.User;
import com.cinema.service.UserService;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email).orElseThrow();
        UserBuilder builder = org.springframework.security.core
                .userdetails.User.withUsername(email);
        builder.password(user.getPassword());
        builder.roles(user.getRoles().stream()
                .map(r -> r.getRoleName().toString())
                .collect(Collectors.toList())
                .toArray(String[]::new));
        return builder.build();
    }
}
