package com.example.v1.repository.customer;

import com.example.v1.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeReposistory extends JpaRepository<CustomerType,Integer> {
}
