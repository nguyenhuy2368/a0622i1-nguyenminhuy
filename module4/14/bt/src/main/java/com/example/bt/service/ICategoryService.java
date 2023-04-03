package com.example.bt.service;

import com.example.bt.model.Blog;
import com.example.bt.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Integer id);

    void update(Category category);

    void remove(Integer id);

    Page<Category> findAll(Pageable pageable, String name);


    List<Blog> findListById(Integer id);
}
