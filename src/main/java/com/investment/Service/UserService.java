package com.investment.Service;

import com.investment.Dto.User.UserLogin;
import com.investment.Dto.User.UserRead;
import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
import com.investment.Mapper.UserMapper;
import io.quarkus.elytron.security.common.BcryptUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    private UserMapper mapper;

    @Transactional
    public User loginUser(UserLogin userLogin){

        return new User();
    }

    @Transactional
    public UserRead registerUser(UserRegister userRegister){
        User user = new User();
        user.setEmail(userRegister.getEmail());
        user.setUsername(userRegister.getUsername());
        user.setName(userRegister.getName());
        user.setPassword(BcryptUtil.bcryptHash(userRegister.getPassword()));
        user.persist();
        return mapper.usertoUserRead(user);
    }

    @Transactional
    public User updateUser(long id,final UserRegister userRegister) {
        User user = User.findById(id);
        user.setEmail(userRegister.getEmail());
        user.setUsername(userRegister.getUsername());
        user.setName(userRegister.getName());
        user.setPassword(userRegister.getPassword());
        user.persist();
        return user;
    }
}
