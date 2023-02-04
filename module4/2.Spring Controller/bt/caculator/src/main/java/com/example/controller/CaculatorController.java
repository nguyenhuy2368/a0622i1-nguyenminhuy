package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("caculator")
    public String getCalculator() {
        return "caculator";
    }

    @GetMapping("action")
    public String addition(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2, @RequestParam("action") String pheptinh, Model model) {
        int result=0;
        String name=null;
        if(pheptinh.equals("addition")){
            result=num1+num2;
            name="Result Addition: ";
        } else if(pheptinh.equals("subtraction")){
            result = num1-num2;
            name="Result Subtraction: ";
        }else if(pheptinh.equals("multiplication")){
            result=num1*num2;
            name="Result Multiplication: ";
        } else if(pheptinh.equals("division")){
            result=num1/num2;
            name="Result Division: ";
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("name", name);
        model.addAttribute("sum", result);
        return "caculator";
    }
}
