package com.GymDietPlanner.Service;

import com.GymDietPlanner.Entity.Login;
import com.GymDietPlanner.Repository.LoginRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements loginDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    @Override
    public Login save(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public boolean checkLogin(Login login) {
        return loginRepository.findAll().stream()
                .anyMatch(existingLogin ->
                        existingLogin.getUsername().equals(login.getUsername()) &&
                        existingLogin.getPassword().equals(login.getPassword()));
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    @Override
    public String deleteLogin(Long id) {
        loginRepository.deleteById(id);
        return "Deleted login with id: " + id;
    }

}
