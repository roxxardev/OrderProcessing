package com.example.restspringbootangular.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime birthDate;
    private LocalDateTime hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;

    @Lob
    private byte[] photo;
    @Lob
    private String notes;
    private Integer reportsTo;
    private String photoPath;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders = new HashSet<>();
}
