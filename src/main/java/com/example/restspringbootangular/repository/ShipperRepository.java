package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Long> {
}
