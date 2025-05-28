package com.example.libraryapp.controller.user;


import com.example.libraryapp.dto.user.request.UserCreateRequest;
import com.example.libraryapp.dto.user.request.UserUpdateRequest;
import com.example.libraryapp.dto.user.response.UserResponse;
import com.example.libraryapp.service.fruit.FruitService;
import com.example.libraryapp.service.user.UserServiceV1;
import com.example.libraryapp.service.user.UserServiceV2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user")//post/user
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

    @GetMapping("/user/error-test")
    public void errorTest() {
        throw new IllegalArgumentException();
    }
}

