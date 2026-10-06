package com.stylecart.stylecart.controller;

import com.stylecart.stylecart.Service.UserService;
import com.stylecart.stylecart.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }
    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(User user) {

        userService.saveUser(user);

        return "redirect:/login";
    }
}