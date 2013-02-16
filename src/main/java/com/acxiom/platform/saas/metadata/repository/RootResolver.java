package com.acxiom.platform.saas.metadata.repository;

import com.acxiom.platform.saas.metadata.EntityType;
import com.sun.jersey.api.core.InjectParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 2/15/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RootResolver implements MetaResolver {
    @Autowired
    private  MetadataRepository repository;

    private static AtomicReference<RootResolver> INSTANCE = new AtomicReference<RootResolver>();

    public RootResolver() {
        final RootResolver previous = INSTANCE.getAndSet(this);
        if (previous != null)
            throw new IllegalStateException("Second singleton");
    }

    public static RootResolver getInstance() {
        return INSTANCE.get();
    }


    public EntityType resolve(String name) {
        if (name != null)
            return repository.getEntity(name);
        else
            return null;
    }

}
