package com.example.restspringbootangular.controller.restController;

import com.example.restspringbootangular.model.Order;
import com.example.restspringbootangular.model.OrderDetail;
import com.example.restspringbootangular.repository.OrderRepository;
import com.example.restspringbootangular.service.order.OrderService;
import com.example.restspringbootangular.service.orderDetail.OrderDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "Orders")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderDetailService orderDetailService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
        this.orderRepository = orderRepository;
    }

    @ApiOperation(value = "Returns Page with orders")
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    Page<Order> getOrders(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size, Pageable pageable) {
        return orderService.getAllByPage(pageable);
    }

    @ApiOperation(value = "Find order by id")
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    ResponseEntity<Order> getOrder(@PathVariable long id) {
        return orderService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Find order details for order by id")
    @RequestMapping(value = "/orders/{id}/orderDetails", method = RequestMethod.GET)
    List<OrderDetail> getOrderDetails(@PathVariable long id) {
        return orderDetailService.getOrderDetails(id);
    }

    @ApiOperation(value = "Get orders count per country")
    @RequestMapping(value = "/orders/countryStatistics", method = RequestMethod.GET)
    List<Map<String, Object>> getOrderStats() {
        return orderRepository.getOrdersCountryCount();
    }
}
