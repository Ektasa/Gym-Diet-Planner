package com.GymDietPlanner.Service;

import com.GymDietPlanner.Entity.Login;
import com.GymDietPlanner.Repository.LoginRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements loginDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    @Override
    public Login save(Login login) {
        return loginRepository.save(login);
    }


}
