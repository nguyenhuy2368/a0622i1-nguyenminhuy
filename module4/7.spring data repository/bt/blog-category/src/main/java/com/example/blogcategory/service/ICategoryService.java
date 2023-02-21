package com.example.blogcategory.service;

import com.example.blogcategory.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);

    void update(Category category);

    Category findById(int id);

    void remove(Category category);
}
