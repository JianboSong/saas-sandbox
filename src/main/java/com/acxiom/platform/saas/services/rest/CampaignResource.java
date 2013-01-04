package com.acxiom.platform.saas.services.rest;

import com.acxiom.platform.saas.model.Campaign;
import com.acxiom.platform.saas.services.CampaignService;
import com.sun.jersey.api.core.InjectParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path("campaign")
public class CampaignResource
{
    @InjectParam
    private CampaignService campaignService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public RestResponse getOne(@PathParam("id") String id)
    {
        return new RestResponse(true, Collections.singletonList(campaignService.getCampaign(id)));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse getAll()
    {
        return new RestResponse(true, campaignService.getCampaigns());
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse remove(@PathParam("id") String id)
    {
        campaignService.removeCampaign(id);
        return new RestResponse(true);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse add(Campaign campaign)
    {
        Campaign newCampaign = campaignService.addCampaign(campaign);
        return new RestResponse(true, Collections.singletonList(newCampaign));
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse update(Campaign campaign)
    {
        campaignService.updateCampaign(campaign);
        return new RestResponse(true, Collections.singletonList(campaign));
    }
}
