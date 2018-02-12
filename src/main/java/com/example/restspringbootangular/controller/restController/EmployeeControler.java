package com.example.restspringbootangular.controller.restController;

import com.example.restspringbootangular.model.Employee;
import com.example.restspringbootangular.service.employee.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@Api(tags = "Employee")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeControler {

    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "Returns Page with employees")
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    Page<Employee> getEmployees(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size, Pageable pageable) {
        return employeeService.getAllByPage(pageable);
    }

    @ApiOperation(value = "Find employee by id")
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        return employeeService.findById(id)
                              .map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Delete employee by id")
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteEmployee(@PathVariable long id) {
        try {
            employeeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Add employee")
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee addedEmployee = employeeService.saveEmployee(employee);
            return ResponseEntity.created(new URI("/employees/" + addedEmployee.getId())).body(addedEmployee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
