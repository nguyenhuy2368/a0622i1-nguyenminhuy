package com.example.product.controller;

import com.example.product.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cart) {
        return new ModelAndView("cart/list", "cart", cart);
    }
}
