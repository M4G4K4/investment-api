package com.investment.Service;

import com.investment.Dto.User.UserEmail;
import com.investment.Dto.User.UserList;
import com.investment.Dto.User.UserResponse;
import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
import com.investment.Exception.CustomException;
import com.investment.Exception.ErrorCode;
import com.investment.Mapper.UserMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserService {

    @Inject
    UserMapper mapper;

    @Transactional
    public UserList getUsers() {
        final PanacheQuery<User> users = User.findAll();
        final List<UserResponse> list = users.stream().map(mapper::usertoUserResponse).collect(Collectors.toList());
        UserList userList = new UserList();
        userList.setUsers(list);
        return userList;
    }

    public UserResponse getUserFromId(final long id) throws CustomException {
        User user = User.findById(id);
        if(user == null){
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        return mapper.usertoUserResponse(user);
    }


    @Transactional
    public User updateUser(long id, final UserRegister userRegister) throws CustomException {
        User user = User.findUserById(id);
        user.setEmail(userRegister.getEmail());
        user.setUsername(userRegister.getUsername());
        user.setName(userRegister.getName());
        user.setPassword(userRegister.getPassword());
        user.persist();
        return user;
    }

    @Transactional
    public Object getUserFromEmail(UserEmail userEmail) throws CustomException {
        User user = User.findUserByEmail(userEmail.getEmail());
        return mapper.usertoUserResponse(user);
    }
}
