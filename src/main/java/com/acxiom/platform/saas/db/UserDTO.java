package com.acxiom.platform.saas.db;

import com.acxiom.platform.saas.model.Campaign;
import com.acxiom.platform.saas.model.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
@SuppressWarnings("serial")
public class UserDTO implements Serializable
{
    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid", parameters = { @Parameter(name="separator", value = "-")})
    @GeneratedValue(generator="system-uuid")
    private String id;

    private String name;

    public UserDTO()
    {
    }

    public UserDTO(User user)
    {
        this.id = user.getId();
        this.name = user.getName();
    }

    @OneToMany(mappedBy = "user")
    private List<CampaignDTO> campaigns = new ArrayList<CampaignDTO>();

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public List<CampaignDTO> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignDTO> campaigns) {
        this.campaigns = campaigns;
    }

    public void setName(String name)
    {

        this.name = name;
    }

}