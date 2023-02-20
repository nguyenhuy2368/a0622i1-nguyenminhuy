package com.example.blognew.repository;

import com.example.blognew.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogsRepository extends JpaRepository<Blogs, Integer> {
    List<Blogs> findByNameContaining(String value);
}
