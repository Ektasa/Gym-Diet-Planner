package com.GymDietPlanner.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<Object> findByUsername(String username);

    Optional<com.GymDietPlanner.Entity.User> findById(Long id);
}
