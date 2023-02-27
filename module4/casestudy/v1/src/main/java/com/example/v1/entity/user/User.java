package com.example.v1.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public class User {
    @Id
    private String username;
    private String password;
}
