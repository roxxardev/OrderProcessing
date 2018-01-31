package com.example.restspringbootangular.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "customers")
//@EqualsAndHashCode(exclude = {"orders"})
public class Customer {

    @Id
    private String id;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();
}
