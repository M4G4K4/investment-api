package com.investment.Resource;

import com.investment.Dto.User.UserEmail;
import com.investment.Dto.User.UserRegister;
import com.investment.Exception.CustomException;
import com.investment.Service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response getUserFromId(@PathParam("id") final long id) throws CustomException {
        return Response.ok(userService.getUserFromId(id)).build();
    }

    @GET
    @Path("/email")
    public Response getUserFromEmail(@Valid UserEmail userEmail) throws CustomException {
        return Response.ok(userService.getUserFromEmail(userEmail)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUserById(@PathParam("id") final long id, @Valid UserRegister userRegister) throws CustomException {
        return Response.ok(userService.updateUser(id, userRegister)).build();
    }
    
}
