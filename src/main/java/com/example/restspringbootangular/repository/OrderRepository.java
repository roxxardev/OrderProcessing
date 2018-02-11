package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select distinct shipCountry as name, count(shipCountry) as value from Order group by shipCountry")
    List<Map<String, Object>> getOrdersCountryCount();
}
