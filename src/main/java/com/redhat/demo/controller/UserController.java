package com.redhat.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.redhat.demo.model.User;
import com.redhat.demo.service.UserService;

public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ArrayList<User> getAllUsers() {
        return userService.findAll();
    }
}
