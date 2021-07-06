package com.investment.Service;

import com.investment.Dto.User.UserLogin;
import com.investment.Dto.User.UserLoginResponse;
import com.investment.Dto.User.UserResponse;
import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
import com.investment.Exception.CustomException;
import com.investment.Exception.ErrorCode;
import com.investment.Mapper.UserMapper;
import com.investment.Token.TokenUtils;
import io.quarkus.elytron.security.common.BcryptUtil;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.wildfly.security.password.Password;
import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.WildFlyElytronPasswordProvider;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.util.ModularCrypt;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class AuthService {

    @Inject
    UserMapper mapper;

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    TokenUtils tokenUtils;

    @Transactional
    public UserLoginResponse loginUser(UserLogin userLogin) throws Exception {
        User user = User.findUserByEmail(userLogin.getEmail());
        if(verifyBCryptPassword(user.getPassword(),userLogin.getPassword())){
            final String token = tokenUtils.generateToken(user);
            return mapper.userToUserLoginResponse(user, token);
        }else{
            throw new CustomException(ErrorCode.BAD_CREDENTIALS);
        }
    }

    @Transactional
    public UserResponse registerUser(UserRegister userRegister){
        User user = new User();
        user.setEmail(userRegister.getEmail());
        user.setUsername(userRegister.getUsername());
        user.setName(userRegister.getName());
        user.setPassword(BcryptUtil.bcryptHash(userRegister.getPassword()));
        user.persist();
        return mapper.usertoUserResponse(user);
    }



    private static boolean verifyBCryptPassword(String bCryptPasswordHash, String passwordToVerify) throws Exception {
        WildFlyElytronPasswordProvider provider = new WildFlyElytronPasswordProvider();

        PasswordFactory passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, provider);

        Password userPasswordDecoded = ModularCrypt.decode(bCryptPasswordHash);

        Password userPasswordRestored = passwordFactory.translate(userPasswordDecoded);

        return passwordFactory.verify(userPasswordRestored, passwordToVerify.toCharArray());

    }
}
