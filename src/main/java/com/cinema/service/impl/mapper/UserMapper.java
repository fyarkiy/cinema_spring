package com.cinema.service.impl.mapper;

import com.cinema.model.User;
import com.cinema.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto mapUserToDto(User user) {
        return new UserResponseDto(user.getEmail());
    }
}
