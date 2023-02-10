package com.example.controller;


import com.example.model.EmailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailSettingController {
    @GetMapping(value = {"", "/setting"})
    private String showFormSetting(Model model) {

        model.addAttribute("listLanguage", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("listSize", new String[]{"5", "10", "15", "25", "50", "100"});
        model.addAttribute("filter", new String[]{"Enable spams filter"});
        model.addAttribute("setting", new EmailSetting());
        return "setting";
    }

    @PostMapping("/result")
    private String showResult(@ModelAttribute("setting") EmailSetting setting, Model model) {
        model.addAttribute("setting", setting);
        return "result";
    }
}
