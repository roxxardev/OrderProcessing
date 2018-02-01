package com.example.restspringbootangular.restController;

import com.example.restspringbootangular.model.Order;
import com.example.restspringbootangular.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(tags = "Orders")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Returns Page with orders")
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    Page<Order> getOrders(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size, Pageable pageable) {
        return orderService.getAllByPage(pageable);
    }

    @ApiOperation(value = "Find order by id")
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    Optional<Order> getOrder(@PathVariable Long id) {
        return orderService.findById(id);
    }

}
