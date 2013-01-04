package com.acxiom.platform.saas.dao;

import com.acxiom.platform.saas.db.QCampaignDTO;
import com.acxiom.platform.saas.db.CampaignDTO;
import com.acxiom.platform.saas.model.Campaign;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CampaignDAOImpl implements CampaignDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    private QCampaignDTO qCampaignDTO = QCampaignDTO.campaignDTO;

    @Override
    public List<Campaign> getCampaigns()
    {
        JPAQuery query = new JPAQuery(entityManager);

        List<Campaign> campaigns = new ArrayList<Campaign>();

        for (CampaignDTO campaignDB : query.from(qCampaignDTO).list(qCampaignDTO))
        {
            campaigns.add(new Campaign(campaignDB));
        }

        return campaigns;
    }

    @Override
    public Campaign getCampaign(String id) {
        JPAQuery query = new JPAQuery(entityManager);

        CampaignDTO campaign = query.from(qCampaignDTO)
                .where(qCampaignDTO.id.eq(id))
                .uniqueResult(qCampaignDTO);
        return new Campaign(campaign);
    }

    @Override
    @Transactional
    public void removeCampaign(String id)
    {
        JPADeleteClause delete = new JPADeleteClause(entityManager, qCampaignDTO);
        delete.where(qCampaignDTO.id.eq(id)).execute();
    }

    @Override
    @Transactional
    public Campaign addCampaign(Campaign campaign)
    {
        CampaignDTO campaignDTO = new CampaignDTO(campaign);

        entityManager.persist(campaignDTO);

        campaign.setId(campaignDTO.getId());
        return campaign;
    }

    @Override
    @Transactional
    public void updateCampaign(Campaign campaign)
    {
        JPAUpdateClause update = new JPAUpdateClause(entityManager, qCampaignDTO);
        update.set(qCampaignDTO.cost, campaign.getCost()).set(qCampaignDTO.startDate, campaign.getStartDate())
            .set(qCampaignDTO.endDate, campaign.getEndDate()). where(qCampaignDTO.id.eq(campaign.getId())).execute();
    }
}
