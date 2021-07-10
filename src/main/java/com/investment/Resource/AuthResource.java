package com.investment.Resource;

import com.investment.Dto.User.UserLogin;
import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
import com.investment.Exception.CustomException;
import com.investment.Service.AuthService;
import com.investment.Service.UserService;
import com.investment.Token.TokenUtils;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
    @Path("/register")
    @PermitAll
    public Response register(@Valid UserRegister userRegister) throws CustomException {
        return Response.ok(authService.registerUser(userRegister)).build();
    }

    @POST
    @Path("/login")
    @PermitAll
    public Response login(@Valid UserLogin userLogin) throws Exception {
        return Response.ok(authService.loginUser(userLogin)).build();
    }

    @GET
    @Path("/me")
    public Response getPermissionsOfUser(){
        //TODO: return roles/allowed permissions of this user
        return Response.ok().build();
    }
}
