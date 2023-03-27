package com.example.v1.serivce.customer;

import com.example.v1.dto.customer.ICustomerDto;
import com.example.v1.entity.customer.Customer;
import com.example.v1.entity.customer.CustomerType;
import com.example.v1.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String typeName, Pageable pageable) {
        return customerRepository.findByNameAndEmailAndCustomerType(name, email, typeName, pageable);
    }

    @Override
    public Page<ICustomerDto> getCustomerUsing(Pageable pageable) {
        return getCustomerUsing(pageable);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerType> getCustomerTypes() {
        return customerRepository.getCustomerType();
    }
}
