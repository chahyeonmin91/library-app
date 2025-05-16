package com.example.libraryapp.service.user;

import com.example.libraryapp.dto.user.request.UserUpdateRequest;
import com.example.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {
        if (userRepository.isUserNotExist(jdbcTemplate, request.getId())) {
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName(jdbcTemplate, request.getName(), request.getId());
    }
}
