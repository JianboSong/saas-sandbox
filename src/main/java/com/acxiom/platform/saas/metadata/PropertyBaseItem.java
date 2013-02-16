package com.acxiom.platform.saas.metadata;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 2/15/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "propertyType")
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = PropertyBaseItem.PROPERTY, value = Property.class),
        @JsonSubTypes.Type(name = PropertyBaseItem.RELATIONSHIP, value = RelationshipProperty.class),
})
public class PropertyBaseItem extends Item {
    public static final String PROPERTY = "property";
    public static final String RELATIONSHIP = "relationshipProperty";
}
