package com.example.blognew.service;

import com.example.blognew.model.Blogs;

import java.util.List;

public interface IBlogsService {
    List<Blogs> findAll();
    Blogs findById(int id);
    void saveBlog(Blogs blogs);
    void deleteBlogById(int id);
    List<Blogs> findByNameContaining(String value);
}
