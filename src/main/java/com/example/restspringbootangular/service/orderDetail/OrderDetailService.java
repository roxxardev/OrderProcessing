package com.example.restspringbootangular.service.orderDetail;

import com.example.restspringbootangular.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getOrderDetails(long orderId);
}
