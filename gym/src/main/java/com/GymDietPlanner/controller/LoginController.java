package com.GymDietPlanner.controller;

import com.GymDietPlanner.Entity.Login;
import com.GymDietPlanner.Service.LoginService;
import com.GymDietPlanner.Service.loginDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final loginDetailsService loginDetailsService;

    public LoginController(loginDetailsService loginDetailsService, loginDetailsService loginDetailsService1) {


        this.loginDetailsService = loginDetailsService1;
    }

    @PostMapping("/submit")
    public String addLogin(@RequestBody Login login) {
//        if(loginDetailsService.checkLogin(login)) {
//            return "Login Successful";
//        }
        Login log=loginDetailsService.save(login);
        return log.getUsername() + " " + log.getPassword();
    }

    @GetMapping("/getuser")
    public List<Login> getData() {
        return loginDetailsService.getAllLogins();
    }
    @PutMapping("/update")
    public Login updateLogin(@RequestBody Login login) {
        return loginDetailsService.save(login);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteLogin(@PathVariable Long id) {
        loginDetailsService.deleteLogin(id);
        return "Deleted login with id: " + id;
    }


}