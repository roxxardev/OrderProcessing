package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "shippers")
public class Shipper {

    @Id
    private Long id;
    private String companyName;
    private String phone;

    @OneToMany(mappedBy = "shipper")
    private Set<Order> orders = new HashSet<>();
}
