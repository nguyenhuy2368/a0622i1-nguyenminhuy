package com.example.thi.service;

import com.example.thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Page<Product> findByNameAndPriceAndType(String name, Integer price, String type,Pageable pageable);

    Optional<Product> findById(int id);

}
