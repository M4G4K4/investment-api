package com.investment.service;

import com.investment.dto.UserRead;
import com.investment.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Transactional
    public User registerUser(UserRead userRead){
        User user = new User();
        user.setEmail(userRead.getEmail());
        user.setUsername(userRead.getUsername());
        user.setName(userRead.getName());
        user.setPassword(userRead.getPassword());
        user.persist();
        return user;
    }
}
