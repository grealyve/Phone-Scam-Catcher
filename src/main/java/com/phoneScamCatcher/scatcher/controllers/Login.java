package com.phoneScamCatcher.scatcher.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@RestController
public class Login {

    @RequestMapping(path = "login",method = RequestMethod.GET)
    public String signin(Principal principal, RedirectAttributes ra){
        return principal == null ? "users/login" : "redirect:/";
    }
}
