package com.stylecart.stylecart.repository;

import com.stylecart.stylecart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CartRepository extends JpaRepository<Cart,Long>{
    List<Cart> findByUserId(Long cartId);
}
