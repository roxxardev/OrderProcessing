package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(unique = true)
    @Email
    private String email;
}
