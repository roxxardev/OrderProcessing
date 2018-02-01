package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "shippers")
public class Shipper {

    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String phone;

    @OneToMany(mappedBy = "shipper")
    private Set<Order> orders = new HashSet<>();
}
