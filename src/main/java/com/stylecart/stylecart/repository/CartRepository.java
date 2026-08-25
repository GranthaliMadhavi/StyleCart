package com.stylecart.stylecart.repository;

import com.stylecart.stylecart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long>{
    
}
