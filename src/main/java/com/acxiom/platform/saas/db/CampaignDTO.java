package com.acxiom.platform.saas.db;

import com.acxiom.platform.saas.model.Campaign;
import com.acxiom.platform.saas.model.User;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "campaign")
@SuppressWarnings("serial")
public class CampaignDTO implements Serializable {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid", parameters = { @org.hibernate.annotations.Parameter(name="separator", value = "-")})
    @GeneratedValue(generator="system-uuid")
    private String id;

    private int cost;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    private UserDTO user;

    public CampaignDTO()
    {
    }

    public CampaignDTO(Campaign campaign)
    {
        this.id = campaign.getId();
        this.cost = campaign.getCost();
        this.startDate = campaign.getStartDate();
        this.endDate = campaign.getEndDate();
        this.user = new UserDTO(campaign.getUser());
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
