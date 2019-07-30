package com.dn.spring_security_example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "loginForm";
    }
}
