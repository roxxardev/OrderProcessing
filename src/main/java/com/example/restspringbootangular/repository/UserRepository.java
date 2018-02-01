package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
