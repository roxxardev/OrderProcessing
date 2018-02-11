package com.example.restspringbootangular.repository;

import com.example.restspringbootangular.model.OrderDetail;
import com.example.restspringbootangular.model.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
    List<OrderDetail> findAllByOrderDetailPK_OrderId(long orderId);

    @Query("select product.productName as name, sum(quantity) as value from OrderDetail group by product.productName")
    List<Map<String, Object>> getProductsOverallQuantity();
}
