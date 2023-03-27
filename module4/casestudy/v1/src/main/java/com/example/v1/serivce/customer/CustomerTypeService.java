package com.example.v1.serivce.customer;

import com.example.v1.entity.customer.CustomerType;
import com.example.v1.repository.customer.ICustomerTypeReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    ICustomerTypeReposistory customerTypeReposistory;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeReposistory.findAll();
    }
}
