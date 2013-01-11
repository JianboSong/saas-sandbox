package com.acxiom.platform.saas.services;

import com.acxiom.platform.saas.metadata.EntityType;
import com.acxiom.platform.saas.metadata.Property;
import com.acxiom.platform.saas.metadata.SimpleType;
import com.acxiom.platform.saas.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

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

    public List<EntityType> getTypes()
    {
        // return campaignDAO.getCampaigns();
        return createList();
    }

    public EntityType getType(String name)
    {
        return createTest();
    }


    public EntityType create(EntityType type)
    {
        // TODO
        return type;
    }

    public void update(EntityType type)
    {
        // TODO
        return;
    }


    private static List<EntityType> createList() {
        List<EntityType> list = Lists.newArrayList(createTest());
        return list;
    }

    private String id;
    private Integer cost;
    private User user;
    private Date startDate;
    private Date endDate;
    private static EntityType createTest() {
        Property p1 = Property.builder().name("name").defaultValue("Acxiom").description("Campaign Name").lable("campaign name").nullable(false).type(SimpleType.STRING).build();
        Property p2 = Property.builder().name("creative").defaultValue("Creative").description("Creative").lable("creative name").nullable(false).type(SimpleType.STRING).build();
        Property p3 = Property.builder().name("id").defaultValue("0").description("id").lable("campaign id").nullable(false).type(SimpleType.INT32).build();
        Property p4 = Property.builder().name("cost").defaultValue("Default Cost").description("Cost").lable("cost").nullable(false).type(SimpleType.STRING).build();
        Property p5 = Property.builder().name("startDate").defaultValue("1-1-2000").description("Start Date").lable("Start Date").nullable(true).type(SimpleType.DATETIME).build();
        Property p6 = Property.builder().name("endDate").defaultValue("1-1-3000").description("End Date").lable("End Date").nullable(true).type(SimpleType.DATETIME).build();
        List<Property> pList = ImmutableList.of(p1, p2, p3, p4, p5, p6);

        EntityType type = EntityType.builder().name("Campaign").namespace("marketingcloud").declaredProperties(pList).build();
        return type;
    }
}
