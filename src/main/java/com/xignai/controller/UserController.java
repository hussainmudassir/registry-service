package com.xignai.controller;

import com.xignai.model.entity.User;
import com.xignai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String welcome(){
        return "Welcome to Xign Ai!";
    }

    @GetMapping("/validate")
    public List<User> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return users;
    }
}
