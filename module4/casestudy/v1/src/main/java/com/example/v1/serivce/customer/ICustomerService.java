package com.example.v1.serivce.customer;

import com.example.v1.dto.customer.ICustomerDto;
import com.example.v1.entity.customer.Customer;
import com.example.v1.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> findByNameAndEmailAndCustomerType(String name,
                                                     String email,
                                                     String typeName,
                                                     Pageable pageable);

    Page<ICustomerDto> getCustomerUsing(Pageable pageable);

    Optional<Customer> findById(int id);

    void save(Customer customer);

    void remove(int id);

    List<CustomerType> getCustomerTypes();
}
