package com.example.blog.service;


import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog>findAllBlog();
    Page<Blog>findAllBlog(Pageable pageable);
    Blog findById(int id);
    void save(Blog blog);
    void remove(Blog blog);
    Page<Blog> findBlogByNameContaining(String nameSearch, Pageable pageable);
    Page<Blog> findBlogByCategory_Name(String categoryName, Pageable pageable);
}
