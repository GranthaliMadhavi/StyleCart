package com.stylecart.stylecart.controller;

import com.stylecart.stylecart.Service.CartService;
import com.stylecart.stylecart.Service.ProductService;
import com.stylecart.stylecart.entity.CartItem;
import com.stylecart.stylecart.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartPageController {

    private final CartService cartService;
    private final ProductService productService;

    public CartPageController(CartService cartService,
                              ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {

        Long userId = 1L;

        List<CartItem> cartItems = cartService.getCartItemsForUser(userId);

        Map<CartItem, Product> cartProducts = new LinkedHashMap<>();

        for (CartItem item : cartItems) {

            Product product = productService.getProductById(item.getProductId());

            cartProducts.put(item, product);
        }
        double grandTotal = 0;

        for(Map.Entry<CartItem,Product> entry : cartProducts.entrySet()){
            CartItem item = entry.getKey();
            Product product = entry.getValue();
            grandTotal += item.getQuantity() * product.getPrice();
        }

        model.addAttribute("grandTotal", grandTotal);
        model.addAttribute("cartProducts", cartProducts);

        return "cart";
    }
}