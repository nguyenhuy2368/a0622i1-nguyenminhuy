package com.example.blogcategory.controller;

import com.example.blogcategory.model.Blog;
import com.example.blogcategory.model.Category;
import com.example.blogcategory.service.IBlogService;
import com.example.blogcategory.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("list")
    public String showBlogList(Model model,
                               @RequestParam(required = false, defaultValue = " ")String searchName,
                               @RequestParam Optional<Integer> page){
        int page1=0;
        if(page.isPresent()){ page1= page.get();}
        Pageable pageable = PageRequest.of(page1,2);
        Page<Blog> blogList = blogService.findBlogByNameContaining(searchName,pageable);
        model.addAttribute("blog",blogList);
        model.addAttribute("searchName",searchName);
        return "blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setTime(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create blog: " + blog.getName() + " ok!");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("category", categoryService.findAll());
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog);
        redirect.addFlashAttribute("mess", "Removed blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("category", categoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Blog blog) {
        blog.setTime(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("category", categoryService.findAll());
        return "blog/view";
    }
}
