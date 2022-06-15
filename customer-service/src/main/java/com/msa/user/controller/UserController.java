package com.msa.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.user.model.User;
import com.msa.user.model.UserDTO;
import com.msa.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User department){
        return userService.create(department);
    }

    @GetMapping
    public List<User> get(){
        return userService.get();
    }

    @GetMapping("/{user-id}")
    public UserDTO getById(@PathVariable("user-id") int userId){
        return userService.getById(userId);
    }
}