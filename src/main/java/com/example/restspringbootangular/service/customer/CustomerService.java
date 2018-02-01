package com.example.restspringbootangular.service.customer;

import com.example.restspringbootangular.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {

    Page<Customer> getAllByPage(Pageable pageable);

    Optional<Customer> findById(String id);

    void deleteById(String id);

    Customer saveCustomer(Customer customer);
}
