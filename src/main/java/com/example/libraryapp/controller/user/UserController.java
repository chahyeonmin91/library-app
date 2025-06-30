package com.example.libraryapp.controller.user;


import com.example.libraryapp.dto.user.request.UserCreateRequest;
import com.example.libraryapp.dto.user.request.UserUpdateRequest;
import com.example.libraryapp.dto.user.response.UserResponse;
<<<<<<< Updated upstream
import com.example.libraryapp.service.fruit.FruitService;
import com.example.libraryapp.service.user.UserServiceV1;
import com.example.libraryapp.service.user.UserServiceV2;
import org.springframework.beans.factory.annotation.Qualifier;
=======
import com.example.libraryapp.service.user.UserServiceV1;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceV2 userService;

<<<<<<< Updated upstream
    public UserController(UserServiceV2 userService) {
        this.userService = userService;
=======
    private final UserServiceV1 userServiceV1;

    public UserController(UserServiceV1 userServiceV1) {
        this.userServiceV1 = userServiceV1;
>>>>>>> Stashed changes
    }

    @PostMapping("/user")//post/user
    public void saveUser(@RequestBody UserCreateRequest request) {
        userServiceV1.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userServiceV1.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userServiceV1.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userServiceV1.deleteUser(name);
    }

    @GetMapping("/user/error-test")
    public void errorTest() {
        throw new IllegalArgumentException();
    }
}

