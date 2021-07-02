package com.investment.resources.User;

import com.investment.dto.UserRead;
import com.investment.entity.User;
import com.investment.service.UserService;

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
    private UserService userService;

    @GET
    public List<User> list() {
        return User.listAll();
    }

    @GET
    @Path("/{id}")
    public User list(@PathParam("id") final long id) {
        return User.findById(id);
    }

    @POST
    public Response register(@Valid UserRead userRead){
        return Response.ok(userService.registerUser(userRead)).build();
    }
}
