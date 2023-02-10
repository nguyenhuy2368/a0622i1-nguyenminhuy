package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping(value = {"", "/product"})
    private String showList(Model model) {
        model.addAttribute("list", productService.findAll());
        return "list";
    }

    @GetMapping("/product/create")
    private String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    private String create(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/detail")
    private String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @GetMapping("/{id}/edit")
    private String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    private String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    private String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    private String remove(Product product) {
        productService.remove(product.getId());
        return "redirect:/product";
    }
}
