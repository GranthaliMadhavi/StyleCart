package com.stylecart.stylecart.controller;

import com.stylecart.stylecart.entity.Product;
import com.stylecart.stylecart.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductPageController {

    private final ProductService productService;

    public ProductPageController(ProductService productService) {
        this.productService = productService;
    }

    // Product listing page
    @GetMapping("/product-page")
    public String products(Model model) {

        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    // Individual product details page
    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable Long id, Model model) {

        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        return "product-details";
    }
}