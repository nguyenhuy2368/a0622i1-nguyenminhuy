package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.model.Product;
import com.example.demo.model.ProductType;
import com.example.demo.service.IBillService;
import com.example.demo.service.IProductService;
import com.example.demo.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    IProductService productService;
    @Autowired
    IProductTypeService productTypeService;
    @Autowired
    IBillService billService;

    @GetMapping("list")
    public String home(Model model, @RequestParam(value = "keyword", defaultValue = "") String keyword,
                       @RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 3);
        model.addAttribute("bills", billService.findAllByRequirement(keyword, pageable));
        return "home";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Bill bill = billService.findById(id);
        model.addAttribute("productType", productTypeService.listAll());
        model.addAttribute("product", productService.listAll());
        model.addAttribute("bill", bill);
        return "edit";
    }

    @PostMapping("update/{id}")
    public String updateBill(@PathVariable("id") Integer id, @Valid Bill bill, BindingResult result, Model model) {
        bill.setBillId(id);
        if (result.hasErrors()) {
            model.addAttribute("product", productService.listAll());
            model.addAttribute("productType", productTypeService.listAll());
            return "edit";
        } else {
            billService.update(bill);
        }
        return "redirect:/bill/list";
    }
    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("bill", new Bill());
        model.addAttribute("products", productService.listAll());
        model.addAttribute("productTypes", productTypeService.listAll());
        return "create";

    }

    @PostMapping("add")
    public String addBill(@Valid Bill bill, BindingResult result, Model model, ProductType productType, Product product) {
//        model.addAttribute("typeProducts", productTypeService.listAll());
        if (result.hasErrors()) {
            model.addAttribute("products", productService.listAll());
            model.addAttribute("productTypes", productTypeService.listAll());
            return "create";
        } else {
            billService.save(bill);
        }
        return "redirect:/bill/list";
    }
}
