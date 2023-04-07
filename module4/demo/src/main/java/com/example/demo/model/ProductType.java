package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public ProductType() {
    }

    public ProductType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    @OneToMany(mappedBy = "productType")
    private Set<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameProduct) {
        this.name = nameProduct;
    }
}
