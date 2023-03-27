package com.example.v1.dto.customer;

import com.example.v1.entity.customer.Customer;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CustomerTypeDto {
    private Integer id;

    private String name;

    private Set<Customer> customers;


}
