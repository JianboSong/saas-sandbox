package com.acxiom.platform.saas.dao;

import com.acxiom.platform.saas.model.Campaign;
import com.acxiom.platform.saas.model.User;

import java.util.List;

public interface CampaignDAO
{
    List<Campaign> getCampaigns();

    Campaign getCampaign(String id);

    void removeCampaign(String id);

    Campaign addCampaign(Campaign campaign);

    void updateCampaign(Campaign campaign);
}