package com.investment.Mapper;

import com.investment.Dto.User.UserLoginResponse;
import com.investment.Dto.User.UserResponse;
import com.investment.Entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {

    public UserResponse usertoUserRead(final User user){
        UserResponse userRead = new UserResponse();
        userRead.setId(user.getId());
        userRead.setName(user.getName());
        userRead.setEmail(user.getEmail());
        userRead.setUsername(user.getUsername());
        userRead.setCreatedAt(user.getCreatedAt());
        return userRead;
    }
    private long id;

    private String name;

    private String email;

    private String username;

    private String token;
    public UserLoginResponse userToUserLoginResponse(final User user,final String token) {
        UserLoginResponse response = new UserLoginResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setToken(token);
        return response;
    }
}
