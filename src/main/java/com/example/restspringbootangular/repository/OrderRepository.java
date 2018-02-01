package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
