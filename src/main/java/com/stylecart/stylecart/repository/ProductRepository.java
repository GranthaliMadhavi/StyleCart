package com.stylecart.stylecart.repository;

import com.stylecart.stylecart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
