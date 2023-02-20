package com.example.blognew.service;

import com.example.blognew.model.Blogs;
import com.example.blognew.repository.IBlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogsService implements IBlogsService {
    @Autowired
    IBlogsRepository blogsRepository;

    @Override
    public List<Blogs> findAll() {
        return blogsRepository.findAll();
    }

    @Override
    public Blogs findById(int id) {
        return blogsRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBlog(Blogs blogs) {
        blogsRepository.save(blogs);
    }

    @Override
    public void deleteBlogById(int id) {
        blogsRepository.deleteById(id);
    }

    @Override
    public List<Blogs> findByNameContaining(String value) {
        return blogsRepository.findByNameContaining(value);
    }


}
