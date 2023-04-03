package com.example.bt.service;

import com.example.bt.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> findAll(Pageable pageable, String name, String note);

    Page<Blog> findAllName(Pageable pageable, String name);


    List<Blog> findListById(Integer id);
}
