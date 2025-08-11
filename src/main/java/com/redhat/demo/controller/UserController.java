package com.redhat.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.demo.model.User;
import com.redhat.demo.repository.UserRepository;
import com.redhat.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private final UserService userService;
   

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public String getAllUsers() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(userRepository.findAll());
        System.out.println(jsonArray);
        return jsonArray;
    }

    @PostMapping(path="/api/user") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved user id : " + n.getId();
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray;
        try {
            jsonArray = objectMapper.writeValueAsString(userRepository.findById(id).orElse(null));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            return "User with id: " + id + " not found!";
        }
        System.out.println(jsonArray);
        return jsonArray;
    }

    @PutMapping("/{id}")
    public @ResponseBody String updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            return "Saved user id : " + id;
        }
        return "Unable to save User with id: " + id + ". User not found!";
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteUser(@PathVariable Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Deleted user id : " + id;
        } else {
            return "Unable to delete User with id: " + id + ". User not found!";
        }
    }

}
