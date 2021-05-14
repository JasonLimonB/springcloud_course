package com.products.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(  strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
