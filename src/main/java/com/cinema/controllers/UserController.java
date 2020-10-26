package com.cinema.controllers;

import com.cinema.model.dto.UserResponseDto;
import com.cinema.service.UserService;
import com.cinema.service.impl.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public UserResponseDto getByEmail(String email) {
        return userMapper.mapUserToDto(userService.findByEmail(email).get());
    }
}
