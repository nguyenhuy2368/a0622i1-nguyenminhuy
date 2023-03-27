package com.example.v1.repository.employee;

import com.example.v1.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT* FROM employee WHERE employee.is_delete = 1", nativeQuery = true)
    List<Employee> findAll();
}
