package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
