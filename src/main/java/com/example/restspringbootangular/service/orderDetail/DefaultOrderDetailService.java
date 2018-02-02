package com.example.restspringbootangular.service.orderDetail;

import com.example.restspringbootangular.model.OrderDetail;
import com.example.restspringbootangular.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOrderDetailService implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public DefaultOrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> getOrderDetails(long orderId) {
        return orderDetailRepository.findAllByOrderDetailPK_OrderId(orderId);
    }
}
