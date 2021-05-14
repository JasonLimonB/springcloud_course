package com.products.services;

import com.products.entities.ProductEntity;
import com.products.repositories.IProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private IProducts iProducts;

    public List<ProductEntity> getProducts(){
        return iProducts.findAll();
    }

    public ProductEntity findProduct( Integer id ){
        Optional<ProductEntity> response = iProducts.findById(id);
        if( response.isPresent() )
            return response.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The product with id %s doesn't exist", id));
    }

    public ProductEntity createProduct( ProductEntity product ){
        return iProducts.save(product);
    }

    public ProductEntity editProduct( Integer id, ProductEntity product ){
        Optional<ProductEntity> response = iProducts.findById(id);
        if( response.isPresent() )
            return iProducts.save(product);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The product with id %s doesn't exist", id));
    }

    public void deleteProduct( Integer id ){
        Optional<ProductEntity> response = iProducts.findById(id);
        if( response.isPresent() )
            iProducts.delete(response.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The product with id %s doesn't exist", id));
    }


}
