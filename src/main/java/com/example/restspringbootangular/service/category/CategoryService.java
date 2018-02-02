package com.example.restspringbootangular.service.category;

import com.example.restspringbootangular.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> findById(long id);
}
