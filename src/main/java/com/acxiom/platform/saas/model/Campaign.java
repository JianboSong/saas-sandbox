package com.acxiom.platform.saas.model;

import com.acxiom.platform.saas.db.CampaignDTO;
import com.acxiom.platform.saas.db.UserDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Campaign {
    private String id;
    private Integer cost;
    private User user;
    private Date startDate;
    private Date endDate;

    public Campaign()
    {
    }

    public Campaign(CampaignDTO campaignDTO)
    {
        this.id = campaignDTO.getId();
        this.cost = campaignDTO.getCost();
        this.startDate = campaignDTO.getStartDate();
        this.endDate = campaignDTO.getEndDate();
        this.user = new User(campaignDTO.getUser());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
