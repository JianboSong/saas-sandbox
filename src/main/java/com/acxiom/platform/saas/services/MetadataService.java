package com.acxiom.platform.saas.services;

import com.acxiom.platform.saas.dao.CampaignDAO;
import com.acxiom.platform.saas.metadata.EntityType;
import com.acxiom.platform.saas.metadata.Property;
import com.acxiom.platform.saas.metadata.SimpleType;
import com.acxiom.platform.saas.metadata.repository.MetadataRepository;
import com.acxiom.platform.saas.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/9/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MetadataService {
    @Autowired
    private MetadataRepository repository;

    @PostConstruct
    public void init() {
        repository.init();
    }

    public List<EntityType> getTypes()
    {
        return repository.getEntities();
    }

    public EntityType getType(String name)
    {
        return repository.getEntity(name);
    }


    public EntityType create(EntityType type)
    {
        return repository.addEntity(type);
    }

    public void update(EntityType type)
    {
        repository.updateEntity(type);
    }



}
