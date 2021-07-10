package com.investment.Token;

import com.investment.Entity.Role;
import com.investment.Entity.User;
import com.investment.Exception.CustomException;
import com.investment.Exception.ErrorCode;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TokenUtils {

    public String generateToken(User user) throws CustomException {
        try{
            return Jwt.issuer("https://github.com/M4G4K4")
                    .upn(user.getEmail())
                    .subject(user.getId().toString())
                    .groups(new HashSet<>(getRolesList(user)))
                    .claim(Claims.birthdate.name(), "2001-07-13")
                    .sign();
        }catch (Exception ex){
            throw new CustomException(ErrorCode.ERROR_GENERATING_TOKEN);
        }
    }

    private List<String> getRolesList(User user){
        if(user.getRoles() == null){
            return Collections.singletonList("stock:read");
        }else {
            return user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        }
    }
}