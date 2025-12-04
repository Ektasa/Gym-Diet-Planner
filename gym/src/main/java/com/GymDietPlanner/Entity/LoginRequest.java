package com.GymDietPlanner.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SignUp")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Mail_Id")
    private String mailId;

    @Column(name = "password")
    private String password;


}
