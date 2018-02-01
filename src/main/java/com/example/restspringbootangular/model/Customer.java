package com.example.restspringbootangular.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
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

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();
}
