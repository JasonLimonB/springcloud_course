package com.stock.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class StockEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idProduct;
    private Integer existence;
    private String ubication;

    public StockEntity(Integer id, Integer idProduct, Integer existence, String ubication) {
        this.id = id;
        this.idProduct = idProduct;
        this.existence = existence;
        this.ubication = ubication;
    }

    public StockEntity() {
    }
}
