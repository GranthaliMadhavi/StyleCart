package com.stylecart.stylecart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.stylecart.stylecart.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ProductPageController {
    private final ProductService productService;

    public ProductPageController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/product-page")
    public String products(Model model){
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }
}
