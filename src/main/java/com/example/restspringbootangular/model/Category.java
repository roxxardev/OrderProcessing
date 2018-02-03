package com.example.restspringbootangular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @Lob
    private byte[] picture;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();
}
