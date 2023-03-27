package com.example.v1.serivce.customer;

import com.example.v1.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();
}
