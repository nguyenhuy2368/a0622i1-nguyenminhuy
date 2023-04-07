package com.example.demo.service;

import com.example.demo.model.ProductType;
import com.example.demo.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService{
    @Autowired
    IProductTypeRepository repository;
    @Override
    public List<ProductType> listAll() {
        return repository.findAll();
    }
}
