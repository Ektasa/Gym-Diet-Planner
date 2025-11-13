package com.GymDietPlanner.controller;

import com.GymDietPlanner.Entity.Login;
import com.GymDietPlanner.Service.LoginService;
import com.GymDietPlanner.Service.loginDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final loginDetailsService loginDetailsService;

    public LoginController(loginDetailsService loginDetailsService, loginDetailsService loginDetailsService1) {


        this.loginDetailsService = loginDetailsService1;
    }

    @PostMapping("/submit")
    public Login addLogin(@RequestBody Login login) {
        return loginDetailsService.save(login);
    }
}