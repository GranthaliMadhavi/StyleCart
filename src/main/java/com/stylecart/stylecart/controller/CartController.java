package com.stylecart.stylecart.controller;

import com.stylecart.stylecart.entity.Cart;
import com.stylecart.stylecart.Service.CartService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @GetMapping("/add/{productId}")
    public ResponseEntity<Void> addToCart(@PathVariable Long productId) {

        Long userId = 1L;

        cartService.addToCart(userId, productId);

        return ResponseEntity.status(302)
                .header("Location", "/product-page")
                .build();
    }
    @GetMapping("/increase/{productId}")
    public ResponseEntity<Void> increaseQuantity(@PathVariable Long productId){
        Long userId = 1L;

        cartService.increaseQuantity(userId, productId);
        
        return ResponseEntity.status(302)
                .header("Location", "/cart")
                .build();
    }
    @GetMapping("/decrease/{productId}")
    public ResponseEntity<Void> decreaseQuantity(@PathVariable Long productId){
        Long userId = 1L;

        cartService.decreaseQuantity(userId, productId);
        return ResponseEntity.status(302)
        .header("Location","/cart")
        .build();
    }
    @GetMapping("/remove/{productId}")
public ResponseEntity<Void> removeItem(@PathVariable Long productId) {

    Long userId = 1L;

    cartService.removeItem(userId, productId);

    return ResponseEntity.status(302)
            .header("Location", "/cart")
            .build();
}
}