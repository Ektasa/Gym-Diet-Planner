package com.GymDietPlanner.Service;


import com.GymDietPlanner.Entity.Login;
import com.GymDietPlanner.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login save(Login login) {
        Login savedLogin = loginRepository.save(login);
        savedLogin.getUsername();
        savedLogin.getPassword();
        return loginRepository.save(login);
    }

}
