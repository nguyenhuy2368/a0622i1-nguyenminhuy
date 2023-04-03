package com.example.bt.service;

import com.example.bt.model.Blog;
import com.example.bt.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String name, String note) {
        return repository.findAllByNameAndAuthor(pageable, "%" + name + "%", "%" + note + "%");
    }

    @Override
    public Page<Blog> findAllName(Pageable pageable, String name) {
        return repository.findAllByName(pageable, "%" + name + "%");
    }

    @Override
    public List<Blog> findListById(Integer id) {
        return repository.findListById(id);
    }
}
