package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    private Long id;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;

    @Lob
    private byte[] photo;
    private String notes;
    private Integer reportsTo;
    private String photoPath;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders = new HashSet<>();
}
