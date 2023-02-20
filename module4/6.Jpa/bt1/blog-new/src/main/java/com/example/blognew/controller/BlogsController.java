package com.example.blognew.controller;

import com.example.blognew.model.Blogs;
import com.example.blognew.service.IBlogsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    IBlogsService blogsService;
    @GetMapping("/list")
    public String showListBlogs (Model model){
        model.addAttribute("listBlogs", blogsService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blogs",new Blogs());
        return "create";
    }
    @PostMapping("/save")
    public String saveBlog(Blogs blogs, RedirectAttributes redirectAttributes){
        LocalDateTime now = LocalDateTime.now();
        blogs.setTime(now);
        blogsService.saveBlog(blogs);
        redirectAttributes.addFlashAttribute("mes","create success");
        return "redirect:/blogs/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("blogs",blogsService.findById(id));
        return "detail";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit (@PathVariable int id,Model model){
        model.addAttribute("blogs",blogsService.findById(id));
        return "edit";
    }
    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id,Model model){
        model.addAttribute("blogs",blogsService.findById(id));
        return "delete";
    }
    @PostMapping("/remove")
    public String deleteBlog(Blogs blogs, RedirectAttributes redirectAttributes){
        blogsService.deleteBlogById(blogs.getId());
        redirectAttributes.addFlashAttribute("mes","delete success");
        return "redirect:/blogs/list";
    }
    @GetMapping("/search")
    public String searchBlog(@RequestParam("value") String value, Model model){
        model.addAttribute("blogSreach",blogsService.findByNameContaining(value));
        return "list";
    }
}
