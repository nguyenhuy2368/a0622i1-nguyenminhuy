package com.example.thi.service;

import com.example.thi.model.ProductType;
import com.example.thi.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductTypeService implements IProductTypeService{
    @Autowired
    IProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
