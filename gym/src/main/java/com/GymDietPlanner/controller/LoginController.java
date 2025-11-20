package com.GymDietPlanner.controller;

import com.GymDietPlanner.Entity.Login;
import com.GymDietPlanner.Service.loginDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    private final loginDetailsService loginDetailsService;

    public LoginController(loginDetailsService loginDetailsService) {
        this.loginDetailsService = loginDetailsService;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> addLogin(@RequestBody Login login) {
        try {
            // Check if user exists
            if(loginDetailsService.checkLogin(login)) {
                return ResponseEntity.ok().body(Map.of("status", "success", "message", "Login Successful", "username", login.getUsername()));
            }
            // Save new login
            Login savedLogin = loginDetailsService.save(login);
            return ResponseEntity.ok().body(Map.of("status", "success", "message", "User registered successfully", "username", savedLogin.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("status", "error", "message", e.getMessage()));
        }
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