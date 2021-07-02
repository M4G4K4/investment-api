package com.investment.Mapper;

import com.investment.Dto.User.UserList;
import com.investment.Dto.User.UserRead;
import com.investment.Entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {

    public UserRead usertoUserRead(final User user){
        UserRead userRead = new UserRead();
        userRead.setId(user.getId());
        userRead.setName(user.getName());
        userRead.setEmail(user.getEmail());
        userRead.setUsername(user.getUsername());
        userRead.setCreatedAt(user.getCreatedAt());
        return userRead;
    }
}
