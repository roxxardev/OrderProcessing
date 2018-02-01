package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
