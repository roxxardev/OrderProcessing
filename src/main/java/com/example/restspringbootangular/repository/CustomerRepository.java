package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
