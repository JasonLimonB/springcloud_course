package com.products.controllers;

import com.products.entities.ProductEntity;
import com.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsService service;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getProuducts(){
        return new ResponseEntity<List<ProductEntity>>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById( @PathVariable Integer id ){
        return new ResponseEntity<ProductEntity>( service.findProduct(id), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<ProductEntity> newProduct(@RequestBody ProductEntity product){
        return new ResponseEntity<ProductEntity>(service.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> editProduct(@PathVariable Integer id, @RequestBody ProductEntity product){
        return new ResponseEntity<ProductEntity>(service.editProduct(id, product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct( @PathVariable Integer id ){
        service.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
