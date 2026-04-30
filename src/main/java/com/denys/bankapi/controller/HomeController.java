package com.denys.bankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    @GetMapping("/")
    public String home() {
        return "Bank API do Denys está online! Use os endpoints de /api/accounts para interagir.";
    }
}