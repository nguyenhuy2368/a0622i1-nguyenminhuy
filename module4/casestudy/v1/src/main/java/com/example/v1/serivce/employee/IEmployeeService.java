package com.example.v1.serivce.employee;

import com.example.v1.entity.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
