package com.investment.Resource;

import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
import com.investment.Service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public Response getAllUsers() {
        return Response.ok(userService.getUsers()).build();
    }

    @GET
    @Path("/{id}")
    public User getUserFromId(@PathParam("id") final long id) {
        return User.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Response updateUserById(@PathParam("id") final long id, @Valid UserRegister userRegister){
        return Response.ok(userService.updateUser(id, userRegister)).build();
    }

    @GET
    @Path("/token")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generateToken(@Context SecurityContext ctx) {
        return Response.ok(userService.generateToken()).build();
    }
}
