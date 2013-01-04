package com.acxiom.platform.saas.model;

import com.acxiom.platform.saas.db.UserDTO;
import com.acxiom.platform.saas.utils.jackson.UserDeserializer;
import com.acxiom.platform.saas.utils.jackson.UserSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class User
{
    private String id;
    private String name;

    @JsonSerialize(using=UserSerializer.class)
    @JsonDeserialize(using=UserDeserializer.class)
    private Map<String, String> metadata;

    public User()
    {

    }
    
    public User(UserDTO userDTO)
    {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}