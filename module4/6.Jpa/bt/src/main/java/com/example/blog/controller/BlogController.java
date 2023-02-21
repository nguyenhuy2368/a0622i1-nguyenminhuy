package com.example.blog.controller;

import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
    public String listBlog(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "list";
    }

    @GetMapping("detail/{id}")
    public String detailBlog(@PathVariable int id ,Model model ){
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }
}
