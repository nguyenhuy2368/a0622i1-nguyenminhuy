package com.example.thi.controller;

import com.example.thi.dto.ProductDto;
import com.example.thi.model.Product;
import com.example.thi.service.IProductService;
import com.example.thi.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @Autowired
    IProductTypeService productTypeService;

    @GetMapping
    public String showList(@RequestParam(value = "nameSearch", defaultValue = "") String name,
                           @RequestParam(name = "priceSearch") Optional<Integer> price,
                           @RequestParam(value = "searchType", defaultValue = "") String type,
                           @PageableDefault(value = 3) Pageable pageable, Model model
    ) {

        Page<Product> productPage = productService.findByNameAndPriceAndType(name, price.orElse(null), type, pageable);

        model.addAttribute("product", productPage);
        model.addAttribute("productType", productTypeService.findAll());
        model.addAttribute("nameSearch", name);
        model.addAttribute("priceSearch", price.orElse(null));
        model.addAttribute("searchType", type);
        return "abc/list";
    }

    @GetMapping("/create")
    public String showCreateProduct(Model model) {
        model.addAttribute("productTypeList", productTypeService.findAll());
        model.addAttribute("productDto", new ProductDto());
        return "/abc/create";
    }

    @PostMapping("/save")
    public String createProduct(@Validated @ModelAttribute ProductDto productDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new ProductDto().validate(productDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productTypeList", productTypeService.findAll());
            model.addAttribute("product", productService.findAll());
            return "/abc/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            product.setIsDelete(1);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "Create product successfully !");
            return "redirect:/product";
        }
    }

    @GetMapping("/delete")
    public String remove(@RequestParam(value = "idDelete") int id, RedirectAttributes redirect) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            redirect.addFlashAttribute("message", "Product not found!");
        } else {
            Product product = optionalProduct.get();
            product.setIsDelete(0);
            productService.save(product);
            redirect.addFlashAttribute("message", "Product removed!");
        }
        return "redirect:/Product";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            redirect.addFlashAttribute("message", "product not found!");
            return "redirect:/product";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(optionalProduct.get(), productDto);
        model.addAttribute("productDto", productDto);
        model.addAttribute("productType", productTypeService.findAll());
        return "abc/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(value = "productDto") ProductDto productDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Product> optionalProduct = productService.findById(productDto.getId());
        if (!optionalProduct.isPresent()) {
            redirect.addFlashAttribute("message", "product not found!");
            return "redirect:/product";
        }
        if (!bindingResult.hasErrors()) {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
            redirect.addFlashAttribute("message", "product saved successfully");
            return "redirect:/product";
        } else {
            redirect.addFlashAttribute("message", "product saved failed");
            return "redirect:/product";
        }
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            redirect.addFlashAttribute("message", "product not found!");
            return "redirect:/product";
        }
        model.addAttribute("product", optionalProduct.get());
        return "redirect:/product";
    }
}
