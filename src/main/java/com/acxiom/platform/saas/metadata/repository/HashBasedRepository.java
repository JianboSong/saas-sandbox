package com.acxiom.platform.saas.metadata.repository;

import com.acxiom.platform.saas.metadata.*;
import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 2/14/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class HashBasedRepository implements MetadataRepository {
    private final Map<String, EntityType> allEntities;

    public HashBasedRepository() {
        allEntities = new HashMap<String, EntityType>();
        //populateTest(this);
    }


    public void init() {
        populateTest(this);
    }

    @Override
    public EntityType addEntity(EntityType entity) {
        allEntities.put(entity.getName(), entity);
        return entity;
    }

    @Override
    public EntityType getEntity(String name) {
        return allEntities.get(name);
    }

    @Override
    public List<EntityType> getEntities() {
        return new ArrayList(allEntities.values());
    }

    @Override
    public void updateEntity(EntityType entity) {
        allEntities.put(entity.getName(), entity);
    }

    @Override
    public void deployEntity(String name) {
        EntityType entity = allEntities.get(name);
        deploySingleEntity(entity);
    }

    @Override
    public void deployAll() {
        for (EntityType e: allEntities.values()) {
            deploySingleEntity(e);
        }
    }

    private void deploySingleEntity(EntityType entity) {
        // TODO Deploy means make type the current type and generate SQL
    }


    public static void populateTest(HashBasedRepository repository) {
        Property pp1 = Property.builder().name("phoneNumber").defaultValue("Acxiom").description("Phone number").label("PhoneNumber").nullable(false).type(SimpleType.INT32).build();
        Property pp2 = Property.builder().name("accountId").defaultValue("0").description("Account Id").label("Account Id").nullable(false).type(SimpleType.STRING).build();
        Property pp3 = Property.builder().name("accountSource").defaultValue("0").description("Account Source").label("Account Source").nullable(false).type(SimpleType.INT32).build();
        List<? extends PropertyBaseItem> ppList = ImmutableList.of(pp1, pp2, pp3);
        EntityType phoneType = EntityType.builder().name("Phone").namespace("marketingcloud").declaredProperties(ppList).build();
        repository.addEntity(phoneType);

        Property p1 = Property.builder().name("name").defaultValue("Acxiom").description("Campaign Name").label("campaign name").nullable(false).type(SimpleType.STRING).build();
        Property p2 = Property.builder().name("creative").defaultValue("Creative").description("Creative").label("creative name").nullable(false).type(SimpleType.STRING).build();
        Property p3 = Property.builder().name("id").defaultValue("0").description("id").label("campaign id").nullable(false).type(SimpleType.INT32).build();
        Property p4 = Property.builder().name("cost").defaultValue("Default Cost").description("Cost").label("cost").nullable(false).type(SimpleType.STRING).build();
        Property p5 = Property.builder().name("startDate").defaultValue("1-1-2000").description("Start Date").label("Start Date").nullable(true).type(SimpleType.DATETIME).build();
        Property p6 = Property.builder().name("endDate").defaultValue("1-1-3000").description("End Date").label("End Date").nullable(true).type(SimpleType.DATETIME).build();
        RelationshipProperty p7 = RelationshipProperty.builder().name("phoneNumbers").description("A List Of Phone Numbers").label("Phone Numbers").relationshipKind(0).
                joinColumns(Arrays.asList("accountId", "accountSource")).targetEntityName("Phone").build();
        List<PropertyBaseItem> pList = ImmutableList.of(p1, p2, p3, p4, p5, p6, p7);

        EntityType type = EntityType.builder().name("Campaign").namespace("marketingcloud").declaredProperties(pList).build();
        repository.addEntity(type);
    }
}
