package com.example.restspringbootangular.service.user;

import com.example.restspringbootangular.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> getByUsername(String username);

    void delete(long id);

    Optional<User> getByEmail(String email);

    Optional<User> getLoggedInUser();

    List<User> getAll();
}
