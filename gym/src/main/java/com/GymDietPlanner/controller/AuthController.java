package com.GymDietPlanner.controller;

import com.GymDietPlanner.Entity.User;
import com.GymDietPlanner.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;



@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {
        String u = body.get("username");
        String p = body.get("password");
        if (u == null || p == null) return ResponseEntity.badRequest().body("username and password required");
        User created = authService.signup(u, p);
        return ResponseEntity.ok(Map.of("id", created.getId(), "username", created.getUsername()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String u = body.get("username");
        String p = body.get("password");
        if (u == null || p == null) return ResponseEntity.badRequest().body("username and password required");
        String token = authService.login(u, p);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
