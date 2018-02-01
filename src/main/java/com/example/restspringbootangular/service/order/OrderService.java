package com.example.restspringbootangular.service.order;

import com.example.restspringbootangular.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAll();

    Optional<Order> findById(Long id);

    Page<Order> getAllByPage(Pageable pageable);
}
