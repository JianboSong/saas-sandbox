package com.acxiom.platform.saas.services.rest;

import java.util.Collections;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acxiom.platform.saas.model.User;
import com.acxiom.platform.saas.services.UsersService;
import com.sun.jersey.api.core.InjectParam;

@Path("users")
public class UsersResource
{
    @InjectParam
    private UsersService usersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public RestResponse getOne(@PathParam("id") String id)
    {
        return new RestResponse(true, Collections.singletonList(usersService.getUser(id)));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse getAll()
    {
        return new RestResponse(true, usersService.getUsers());
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse remove(@PathParam("id") String id)
    {
        usersService.removeUser(id);
        return new RestResponse(true);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse add(User user)
    {
        User newUser = usersService.addUser(user);
        return new RestResponse(true, Collections.singletonList(newUser));
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse update(User user)
    {
        usersService.updateUser(user);
        return new RestResponse(true, Collections.singletonList(user));
    }    
}
