package com.acxiom.platform.saas.metadata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/9/13
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityTypeTest {

    @Test
    public void testBuilder() throws Exception {
        Property p1 = Property.builder().name("name").defaultValue("Acxiom").description("Default Campaign Name").lable("campaign name").nullable(false).type(SimpleType.STRING).build();
        Property p2 = Property.builder().name("creative").defaultValue("Creative").description("Default Creative").lable("creative name").nullable(false).type(SimpleType.STRING).build();
        List<Property> pList = new ArrayList<Property>();
        pList.add(p1);
        pList.add(p2);
        EntityType type = EntityType.builder().name("Campaign").namespace("marketingcloud").declaredProperties(pList).build();
        assertEquals("Campaign", type.getName());
        assertEquals("creative", type.getDeclaredProperties().get(1).getName());
        assertEquals("String", type.getDeclaredProperties().get(1).getType().getFullyQualifiedTypeName());

    }
}
