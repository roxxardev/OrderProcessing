package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
