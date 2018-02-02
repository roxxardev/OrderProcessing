package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.OrderDetail;
import com.example.restspringbootangular.model.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
    List<OrderDetail> findAllByOrderDetailPK_OrderId(long orderId);
}
