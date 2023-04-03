package com.example.bt.service;

import com.example.bt.model.Blog;
import com.example.bt.model.Category;
import com.example.bt.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Category category) {
repository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Category category) {
repository.save(category);
    }

    @Override
    public void remove(Integer id) {
repository.deleteById(id);
    }

    @Override
    public Page<Category> findAll(Pageable pageable, String name) {
        return repository.findAllByName(pageable,"%" + name + "%");
    }

    @Override
    public List<Blog> findListById(Integer id) {
        return repository.findListById(id);
    }
}
