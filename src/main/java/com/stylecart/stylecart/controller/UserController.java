package com.stylecart.stylecart.controller;

import com.stylecart.stylecart.Service.UserService;
import com.stylecart.stylecart.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController {

    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
    @PostMapping("/login")
    public String loginUser(User user,HttpSession session){
        User existingUser = userService
            .findUserByEmail(user.getEmail())
            .orElse(null);

    if (existingUser != null &&
            passwordEncoder.matches(
                    user.getPassword(),
                    existingUser.getPassword())) {

        session.setAttribute("userId", existingUser.getId());
        session.setAttribute("userName", existingUser.getFullName());
        session.setAttribute("userRole", existingUser.getRole());

        return "redirect:/product-page";
    }

    return "redirect:/login?error=true";
    }
}