package com.example.restspringbootangular.service.employee;

import com.example.restspringbootangular.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> getAllByPage(Pageable pageable);

    Optional<Employee> findById(long id);

    void deleteById(long id);

    Employee saveEmployee(Employee employee);
}
