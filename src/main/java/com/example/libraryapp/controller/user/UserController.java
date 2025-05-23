package com.example.libraryapp.controller.user;


import com.example.libraryapp.dto.user.request.UserCreateRequest;
import com.example.libraryapp.dto.user.request.UserUpdateRequest;
import com.example.libraryapp.dto.user.response.UserResponse;
import com.example.libraryapp.repository.user.UserRepository;
import com.example.libraryapp.service.fruit.FruitService;
import com.example.libraryapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final FruitService fruitService;

//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    public UserController(UserService userService, @Qualifier("m") FruitService fruitService) {
        this.userService = userService;
        this.fruitService = fruitService;
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
