package com.example.bt.service;

import com.example.bt.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(int id);
}
