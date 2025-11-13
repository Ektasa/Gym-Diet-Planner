package com.GymDietPlanner.Service;

import com.GymDietPlanner.Entity.Login;
import jakarta.transaction.Transactional;

public interface loginDetailsService  {


    @Transactional
    Login save(Login login);

}
