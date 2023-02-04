package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    List<String[]> condimentList = new ArrayList<>();

    @GetMapping("/sandwich")
    public String getSandwich() {
        return "/sandwich";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        condimentList.add(condiment);
        model.addAttribute("condimentList", condimentList);
        return "/result";
    }
}
