package com.example.product.controller;

import com.example.product.dto.CartDto;
import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;
    @ModelAttribute("cart")
    public CartDto setupCartDto(){
        return new CartDto();
    }
    @GetMapping
    public ModelAndView showListPage(Model model,
                                     @CookieValue(value = "idProduct",
                                             defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        return new ModelAndView("product/list", "product", productService.findAll());
    }

    @GetMapping("view/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {

        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ModelAndView("error.404");
        }
        return new ModelAndView("view", "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error.404";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOptional.get(), productDto);
        if (action.equals("show+")) {
            cart.addProduct(productDto);
            return "redirect:/shopping-cart";
        }
        if (action.equals("show-")) {
            cart.removeProduct(productDto);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productDto);
        return "redirect:/shop";
    }

}
