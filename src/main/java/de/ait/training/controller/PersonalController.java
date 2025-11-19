package de.ait.training.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonalController {
    @GetMapping("/public/hello")
    public String publicHello(){
        return "Hello, I am public API, available without login !";
    }

    @GetMapping("/user/hello")
    public String userHello(Authentication authentication){
        return "Hello, " + authentication.getName() + ". It is API for USER or ADMIN";
    }

    @GetMapping("/admin/hello")
    public String adminHello(Authentication authentication){
        return "Hello, " + authentication.getName() + ". It is API for ADMIN";
    }

    @GetMapping("/manager/hello")
    public String managerHello(Authentication authentication){
        return "Hello, " + authentication.getName() + ". It is API for MANAGER";
    }
}