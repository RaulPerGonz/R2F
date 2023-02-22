package com.example.rpg0904.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "public/loginView";
    }

    @GetMapping("/accessError")
    public String showError() {
        return "public/ErrorView";
    }

    @PostMapping("/logout")
    public String showLogout() {
        return "public/indexView";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "public/registroView";
    }

}
