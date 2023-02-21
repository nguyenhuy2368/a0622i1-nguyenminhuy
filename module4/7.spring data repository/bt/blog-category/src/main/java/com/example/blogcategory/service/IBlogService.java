package com.example.blogcategory.service;

import com.example.blogcategory.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog>findAllBlog();
    Blog findById(int id);
    void save(Blog blog);
    void remove(Blog blog);
    Page<Blog> findBlogByNameContaining(String nameSearch, Pageable pageable);
    Page<Blog> findBlogByCategory_Name(String categoryName,Pageable pageable);
}
