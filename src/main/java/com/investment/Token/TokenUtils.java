package com.investment.Token;

import java.util.Arrays;
import java.util.HashSet;

import com.investment.Entity.User;
import com.investment.Exception.CustomException;
import com.investment.Exception.ErrorCode;
import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenUtils {

    public String generateToken(User user) throws CustomException {
        try{
            return Jwt.issuer("https://github.com/M4G4K4")
                    .upn(user.getEmail())
                    .subject(user.getId().toString())
                    .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                    .claim(Claims.birthdate.name(), "2001-07-13")
                    .sign();
        }catch (Exception ex){
            throw new CustomException(ErrorCode.ERROR_GENERATING_TOKEN);
        }
    }
}