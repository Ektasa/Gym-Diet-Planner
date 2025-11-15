package com.GymDietPlanner.Service;

import com.GymDietPlanner.Entity.Login;
import jakarta.transaction.Transactional;

import java.util.List;

public interface loginDetailsService  {


    @Transactional
    Login save(Login login);

    boolean checkLogin(Login login);

    List<Login> getAllLogins();
    String deleteLogin(Long id);
}
