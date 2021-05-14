package com.products.repositories;

import com.products.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducts extends JpaRepository<ProductEntity, Integer> {
}
