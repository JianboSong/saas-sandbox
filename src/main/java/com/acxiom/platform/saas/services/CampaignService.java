package com.acxiom.platform.saas.services;

import com.acxiom.platform.saas.dao.CampaignDAO;
import com.acxiom.platform.saas.dao.UserDAO;
import com.acxiom.platform.saas.model.Campaign;
import com.acxiom.platform.saas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService
{
    @Autowired
    private CampaignDAO campaignDAO;
    
    public List<Campaign> getCampaigns()
    {
        return campaignDAO.getCampaigns();
    }

    public Campaign getCampaign(String id)
    {
        return campaignDAO.getCampaign(id);
    }

    public void removeCampaign(String id)
    {
        campaignDAO.removeCampaign(id);
    }

    public Campaign addCampaign(Campaign campaign)
    {
        return campaignDAO.addCampaign(campaign);
    }

    public void updateCampaign(Campaign campaign)
    {
        campaignDAO.updateCampaign(campaign);
    }
}
