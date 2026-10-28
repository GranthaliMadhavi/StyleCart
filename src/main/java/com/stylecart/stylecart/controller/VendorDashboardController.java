
package com.stylecart.stylecart.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VendorDashboardController {

    @GetMapping("/vendor/dashboard")
    public String vendorDashboard(
            HttpSession session, Model model) {

        String role = (String) session.getAttribute("userRole");

        if (role == null) {
            return "redirect:/login";
        }

        if (!"VENDOR".equals(role)) {
            return "redirect:/product-page";
        }

        model.addAttribute(
                "vendorName",
                session.getAttribute("userName"));

        return "vendor-dashboard";
    }
    @GetMapping("/vendor/products/new")
public String showAddProductForm(HttpSession session) {

    String role = (String) session.getAttribute("userRole");

    if (role == null) {
        return "redirect:/login";
    }

    if (!"VENDOR".equals(role)) {
        return "redirect:/product-page";
    }

    return "vendor-add-product";
}
}
