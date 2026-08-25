package com.stylecart.stylecart.controller;

import com.stylecart.stylecart.entity.Cart;
import com.stylecart.stylecart.Service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    
    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @PostMapping
    public Cart saveCart(@RequestBody Cart cart){
        return cartService.saveCart(cart);
    }
}
