package com.acxiom.platform.saas.metadata.repository;

import com.acxiom.platform.saas.metadata.EntityType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 2/14/13
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MetadataRepository {

    public void init();

    public EntityType getEntity(String name);

    public List<EntityType> getEntities();

    public EntityType addEntity(EntityType entity);

    public void updateEntity(EntityType entity);

    public void deployEntity(String name);

    public void deployAll();
}
