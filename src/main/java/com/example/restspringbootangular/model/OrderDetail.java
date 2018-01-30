package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_details")
public class OrderDetail {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal discount;

}
