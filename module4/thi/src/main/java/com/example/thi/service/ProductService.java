package com.example.thi.service;

import com.example.thi.model.Product;
import com.example.thi.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {

        productRepository.save(product);
    }

    @Override
    public Page<Product> findByNameAndPriceAndType(String name, Integer price, String type, Pageable pageable) {
        return productRepository.findByNameAndPriceAndType(name, price, type, pageable);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

}
