package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    @GetMapping("form")
    public String showForm() {
        return "form";
    }


    @PostMapping("exchange")
    public String showResult(@RequestParam("usd") int usd, Model model) {
        model.addAttribute("vnd",usd*25000  );
        return "form";
    }
}
