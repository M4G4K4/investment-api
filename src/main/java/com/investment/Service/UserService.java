package com.investment.Service;

import com.investment.Dto.User.UserList;
import com.investment.Dto.User.UserRead;
import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
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
        final List<UserRead> list = users.stream().map(mapper::usertoUserRead).collect(Collectors.toList());
        UserList userList = new UserList();
        userList.setUsers(list);
        return userList;
    }


    @Transactional
    public User updateUser(long id,final UserRegister userRegister) {
        //TODO Do it with ampper
        User user = User.findById(id);
        user.setEmail(userRegister.getEmail());
        user.setUsername(userRegister.getUsername());
        user.setName(userRegister.getName());
        user.setPassword(userRegister.getPassword());
        user.persist();
        return user;
    }
}
