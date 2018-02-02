package com.example.restspringbootangular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {


    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "orderId", column = @Column(name = "order_id")),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id"))
    })
    private OrderDetailPK orderDetailPK;

    @JsonIgnore
    @MapsId("orderId")
    @ManyToOne
    private Order order;

    @JsonIgnore
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    @ManyToOne
    private Product product;

    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal discount;

}
