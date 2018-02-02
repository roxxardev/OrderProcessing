package com.example.restspringbootangular.service.product;

import com.example.restspringbootangular.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProductService {
    Page<Product> getAllByPage(Pageable pageable);

    Optional<Product> findById(long id);

    void deleteById(long id);

    Product saveProduct(Product product);
}
