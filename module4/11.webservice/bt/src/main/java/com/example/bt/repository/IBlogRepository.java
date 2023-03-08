package com.example.bt.repository;


import com.example.bt.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog>findBlogsByNameContaining(String value, Pageable pageable);
    Page<Blog> findBlogsByCategory_Name(String categoryName, Pageable pageable);
}
