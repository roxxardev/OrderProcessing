package com.example.restspringbootangular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String productName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails = new HashSet<>();
}
