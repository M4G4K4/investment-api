package com.investment.Resource.User;

import com.investment.Dto.User.UserRegister;
import com.investment.Entity.User;
import com.investment.Service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @Inject
    UserUtils userUtils;

    @GET
    public Response list() {
        return Response.ok(userService.getUsers()).build();
    }

    @GET
    @Path("/{id}")
    public User list(@PathParam("id") final long id) {
        return User.findById(id);
    }

    @POST
    public Response register(@Valid UserRegister userRegister){
        return Response.ok(userService.registerUser(userRegister)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") final long id, @Valid UserRegister userRegister){
        return Response.ok(userService.updateUser(id, userRegister)).build();
    }
}
