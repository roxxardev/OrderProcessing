package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private Long shipVia;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipState;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;


}
