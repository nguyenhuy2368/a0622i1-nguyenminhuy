package com.example.v1.controller;

import com.example.v1.dto.customer.CustomerDto;
import com.example.v1.dto.customer.ICustomerDto;
import com.example.v1.entity.customer.Customer;
import com.example.v1.serivce.customer.ICustomerService;
import com.example.v1.serivce.customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping
    public String showList(@RequestParam(value = "nameSearch", defaultValue = "") String name,
                           @RequestParam(value = "emailSearch", defaultValue = "") String email,
                           @RequestParam(value = "searchCustomerType", defaultValue = "") String typeName,
                           @PageableDefault(value = 3) Pageable pageable, Model model
    ) {
        Page<Customer> customerPage = customerService.findByNameAndEmailAndCustomerType(name, email, typeName, pageable);

        model.addAttribute("customer", customerPage);
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("nameSearch", name);
        model.addAttribute("emailSearch", email);
        model.addAttribute("searchCustomerType", typeName);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @GetMapping("/using")
    public String showCustomerUsing(@PageableDefault(value = 3) Pageable pageable, Model model){
        Page<ICustomerDto> customerDtos = customerService.getCustomerUsing(pageable);
        model.addAttribute("customer", customerDtos);
        return "customer/using";
    }

    @PostMapping("/save")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            model.addAttribute("customer", customerService.findAll());
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setIsDelete(1);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create customer successfully !");
            return "redirect:/customer";
        }
    }

    @GetMapping("/delete")
    public String remove(@RequestParam(value = "idDelete") int id, RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
        } else {
            Customer customer = optionalCustomer.get();
            customer.setIsDelete(0);
            customerService.save(customer);
            redirect.addFlashAttribute("message", "Customer removed!");
        }
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
            return "redirect:/customer";
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(optionalCustomer.get(), customerDto);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(value = "customerDto") CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(customerDto.getId());
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
            return "redirect:/customer";
        }
        if (!bindingResult.hasErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirect.addFlashAttribute("message", "Customer saved successfully");
            return "redirect:/customer";
        } else {
            redirect.addFlashAttribute("message", "Customer saved failed");
            return "redirect:/customer";
        }
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            redirect.addFlashAttribute("message", "Customer not found!");
            return "redirect:/customer";
        }
        model.addAttribute("customer", optionalCustomer.get());
        return "redirect:/customer";
    }
}
