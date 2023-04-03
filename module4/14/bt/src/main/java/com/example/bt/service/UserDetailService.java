package com.example.bt.service;

import com.example.bt.model.MyUserDetail;
import com.example.bt.model.User;
import com.example.bt.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    IUserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        if (user==null){
            throw new UsernameNotFoundException("user name" + username+ "not found");
        }
        return new MyUserDetail(user);
    }
}
