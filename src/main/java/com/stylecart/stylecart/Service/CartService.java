package com.stylecart.stylecart.Service;

import com.stylecart.stylecart.entity.Cart;
import com.stylecart.stylecart.entity.CartItem;
import com.stylecart.stylecart.repository.CartItemRepository;
import com.stylecart.stylecart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository,
                       CartItemRepository cartItemRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public void addToCart(Long userId, Long productId) {

        // Find existing cart for the user
        List<Cart> carts = cartRepository.findByUserId(userId);

        Cart cart;

        if (carts.isEmpty()) {
            // Create a new cart
            cart = new Cart();
            cart.setUserId(userId);
            cart = cartRepository.save(cart);
        } else {
            // Use existing cart
            cart = carts.get(0);
        }

        // Check if product is already in the cart
        CartItem cartItem = cartItemRepository
                .findByCartIdAndProductId(cart.getId(), productId)
                .orElse(null);

        if (cartItem == null) {

            // Product is not in cart → create new item
            cartItem = new CartItem();
            cartItem.setCartId(cart.getId());
            cartItem.setProductId(productId);
            cartItem.setQuantity(1);

        } else {

            // Product already exists → increase quantity
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }

        cartItemRepository.save(cartItem);
    }
    public List<CartItem> getCartItemsForUser(Long userId){
        List<Cart> carts = cartRepository.findByUserId(userId);

        if (carts.isEmpty()){
            return List.of();
        }
            Cart cart = carts.get(0);
            return cartItemRepository.findByCartId(cart.getId());

    }
    public void increaseQuantity(Long userId, Long productId) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        if(carts.isEmpty()){
            return ;
        }
        Cart cart = carts.get(0);
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId).orElse(null);

        if(cartItem != null){
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItemRepository.save(cartItem);
        }
        }
    public void decreaseQuantity(Long userId, Long productId) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        if(carts.isEmpty()){
            return;
        }
        Cart cart = carts.get(0);

        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId).orElse(null);

        if (cartItem != null && cartItem.getQuantity() > 1){
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            cartItemRepository.save(cartItem);

        }
    }
    public void removeItem(Long userId, Long productId) {

    List<Cart> carts = cartRepository.findByUserId(userId);

    if (carts.isEmpty()) {
        return;
    }

    Cart cart = carts.get(0);

    CartItem cartItem = cartItemRepository
            .findByCartIdAndProductId(cart.getId(), productId)
            .orElse(null);

    if (cartItem != null) {
        cartItemRepository.delete(cartItem);
    }
}
}