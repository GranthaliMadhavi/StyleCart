package com.stylecart.stylecart.Service;

import com.stylecart.stylecart.entity.Cart;
import com.stylecart.stylecart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public Cart saveCart(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }
    
}
