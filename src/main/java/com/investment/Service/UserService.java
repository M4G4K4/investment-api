package com.investment.Service;

import com.investment.Dto.User.UserList;
import com.investment.Dto.User.UserLogin;
import com.investment.Dto.User.UserRead;
import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
import com.investment.Exception.CustomException;
import com.investment.Exception.ErrorCode;
import com.investment.Mapper.UserMapper;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.wildfly.security.password.Password;
import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.WildFlyElytronPasswordProvider;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.util.ModularCrypt;

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
    public User loginUser(UserLogin userLogin) throws Exception {
        User user = User.find("email", userLogin.getEmail()).firstResult();
        if(verifyBCryptPassword(user.getPassword(),userLogin.getPassword())){
            // password verified
            return new User();
        }else{
            // Wrong password
            throw new CustomException(ErrorCode.BAD_CREDENTIALS);
        }
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

    private static boolean verifyBCryptPassword(String bCryptPasswordHash, String passwordToVerify) throws Exception {
        WildFlyElytronPasswordProvider provider = new WildFlyElytronPasswordProvider();

        PasswordFactory passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, provider);

        Password userPasswordDecoded = ModularCrypt.decode(bCryptPasswordHash);

        Password userPasswordRestored = passwordFactory.translate(userPasswordDecoded);

        return passwordFactory.verify(userPasswordRestored, passwordToVerify.toCharArray());

    }

}
