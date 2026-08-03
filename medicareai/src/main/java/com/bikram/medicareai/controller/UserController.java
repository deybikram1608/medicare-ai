package com.bikram.medicareai.controller;

import com.bikram.medicareai.entity.User;
import com.bikram.medicareai.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
    return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserByID(@PathVariable Long id){
        return userService.findUserById(id);
    }
}
