package com.example.v1.entity.user;

import com.example.v1.entity.employee.Employee;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User {
    @Id
    private String username;
    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;
}
