package com.phoneScamCatcher.scatcher.controller;

import com.phoneScamCatcher.scatcher.entity.User;
import com.phoneScamCatcher.scatcher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="")
    public String sayHello(){
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("Register request: "+ user);
        userRepository.save(user);
        return "login_page";
    }

    @PostMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }
}
