package com.GymDietPlanner.Service;


import com.GymDietPlanner.Entity.Role;
import com.GymDietPlanner.Entity.User;
import com.GymDietPlanner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

//import jakarta.management.relation.Role;
import java.util.*;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // simple token store for demo (token -> userId)
    private Map<String, Long> sessions = new HashMap<>();

    public User signup(String username, String rawPassword) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("username_taken");
        }
        User u = new User();
        u.setUsername(username);
        u.setPassword(encoder.encode(rawPassword));
        u.getRoles().add(Role.USER);
        return userRepository.save(u);
    }

    public String login(String username, String rawPassword) {
        User u = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("invalid_credentials"));
        if (!encoder.matches(rawPassword, u.getPassword())) {
            throw new IllegalArgumentException("invalid_credentials");
        }
        String token = UUID.randomUUID().toString();
        sessions.put(token, u.getId());
        return token;
    }

    public Optional<User> validateToken(String token) {
        if (token == null) return Optional.empty();
        Long id = sessions.get(token);
        if (id == null) return Optional.empty();
        return userRepository.findById(id);
    }

    @PostConstruct
    private void seedAdmin() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User a = new User();
            a.setUsername("admin");
            a.setPassword(encoder.encode("adminpass"));
            a.getRoles().add(Role.ADMIN);
            userRepository.save(a);
        }
    }
}
