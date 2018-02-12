package com.example.restspringbootangular.controller.restController;

import com.example.restspringbootangular.model.Customer;
import com.example.restspringbootangular.service.customer.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(tags = "Customers")
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Returns Page with customers")
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    Page<Customer> getCustomers(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size, Pageable pageable) {
        return customerService.getAllByPage(pageable);
    }

    @ApiOperation(value = "Find customer by id")
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Delete customer by id")
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        try {
            customerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (DataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Add customer")
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer addedCustomer = customerService.saveCustomer(customer);
            return ResponseEntity.created(new URI("/customers/" + addedCustomer.getId())).body(addedCustomer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
