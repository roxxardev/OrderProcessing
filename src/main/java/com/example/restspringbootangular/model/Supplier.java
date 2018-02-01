package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name ="suppliers")
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

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
    private String homePage;

    @OneToMany(mappedBy = "supplier")
    private Set<Product> products = new HashSet<>();
}
