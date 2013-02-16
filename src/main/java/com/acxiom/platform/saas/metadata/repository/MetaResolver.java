package com.acxiom.platform.saas.metadata.repository;

import com.acxiom.platform.saas.metadata.EntityType;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 2/15/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MetaResolver {

    public EntityType resolve(String name);
}
