package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog>findAll();
    Blog findById(int id);
    void saveBlog(Blog blog);
    void deleteBlogById(int id);
}
