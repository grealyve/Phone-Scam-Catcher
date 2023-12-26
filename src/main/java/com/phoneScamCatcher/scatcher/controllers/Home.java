package com.phoneScamCatcher.scatcher.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping(path="")
    public String sayHello(){
        return "Home Page";
    }
}
