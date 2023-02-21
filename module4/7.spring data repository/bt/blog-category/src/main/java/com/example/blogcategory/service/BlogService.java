package com.example.blogcategory.service;

import com.example.blogcategory.model.Blog;
import com.example.blogcategory.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findBlogByNameContaining(String nameSearch, Pageable pageable) {
        return blogRepository.findBlogsByNameContaining(nameSearch,pageable);
    }


    @Override
    public Page<Blog> findBlogByCategory_Name(String categoryName, Pageable pageable) {
        return blogRepository.findBlogsByCategory_Name(categoryName, pageable);
    }
}
