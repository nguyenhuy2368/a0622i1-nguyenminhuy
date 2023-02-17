package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping
    public ModelAndView showList(){
        List<Blog> list =blogService.findAll();
        return new ModelAndView("home","list",list);
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("create","blog",new Blog());
    }
    @PostMapping("/save")
    public String createNewBlog(Blog blog, Model model){
        blogService.saveBlog(blog);
        model.addAttribute("blog",new Blog());
        model.addAttribute("success","New blog success");
        return "create";
    }
}
