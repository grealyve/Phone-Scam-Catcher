package com.phoneScamCatcher.scatcher.controller;

import com.phoneScamCatcher.scatcher.entity.User;
import com.phoneScamCatcher.scatcher.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UsersService usersService;

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
    @ResponseBody
    public String register(@ModelAttribute User user){
        System.out.println("Register request: "+ user);
        User registeredUser = usersService.registerUser(user.getName(), user.getPassword(), user.getPhoneNumber());
        return registeredUser == null ? "error!" : "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        User dbUser = usersService.authenticate(user.getPhoneNumber(), user.getPassword());
        if (dbUser != null){
            System.out.println("Successfully loginned" + user.getName());
            return "report_page";
        }else
            return "Failed to login";
    }
}
