package com.hackaton.eHealth.controller;

import com.hackaton.eHealth.entities.User;
import com.hackaton.eHealth.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add-user")
    public void createUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
