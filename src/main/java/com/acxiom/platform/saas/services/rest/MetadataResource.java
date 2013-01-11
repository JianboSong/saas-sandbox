package com.acxiom.platform.saas.services.rest;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/9/13
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */

import com.acxiom.platform.saas.metadata.EntityType;
import com.acxiom.platform.saas.services.MetadataService;
import com.sun.jersey.api.core.InjectParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path("metadata")
public class MetadataResource
{
    @InjectParam
    private MetadataService metadataService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public RestResponse getOne(@PathParam("name") String name)
    {
        return new RestResponse(true, Collections.singletonList(metadataService.getType(name)));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse getAll()
    {
        return new RestResponse(true, metadataService.getTypes());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse create(EntityType type)
    {
        EntityType newType = metadataService.create(type);
        return new RestResponse(true, Collections.singletonList(newType));
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse update(EntityType type)
    {
        metadataService.update(type);
        return new RestResponse(true, Collections.singletonList(type));
    }
}

