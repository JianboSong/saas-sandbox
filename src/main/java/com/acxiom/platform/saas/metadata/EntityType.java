package com.acxiom.platform.saas.metadata;

import com.acxiom.platform.saas.metadata.repository.RootResolver;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/7/13
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityType extends Item{
    private final String namespace;
    private final List<? extends PropertyBaseItem> declaredProperties;
    private final String name;
    private final String description;
    private final String label;
    private final String tableName;
    private EntityType baseType;

    @JsonCreator
    public EntityType(
            @JsonProperty("name") String name,
            @JsonProperty("namespace") String namespace,
            @JsonProperty("properties") List<? extends PropertyBaseItem> declaredProperties,
            @JsonProperty("label") String label,
            @JsonProperty("description") String description,
            @JsonProperty("tableName") String tableName,
            @JsonProperty("baseType") String baseType) {
        this(name, namespace, declaredProperties, label, description, tableName,
                baseType!= null ? RootResolver.getInstance().resolve(baseType): null);
    }

    public EntityType(String name, String namespace, List<? extends PropertyBaseItem> declaredProperties, String description, String label, String tableName, EntityType baseType) {
        this.name = name;
        this.declaredProperties = declaredProperties;
        this.namespace = namespace;
        this.baseType = baseType;
        this.label = label;
        this.description = description;
        this.tableName = tableName;
    }


    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getLabel() {
        return label;
    }

    @JsonProperty
    public String getTableName() {
        return tableName;
    }

    @JsonProperty
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("properties")
    public List<? extends PropertyBaseItem> getDeclaredProperties() {
        return declaredProperties;
    }


    @JsonIgnore
    public EntityType getBaseType() {
        return baseType;
    }

    @JsonProperty("baseType")
    public String getBaseTypeName() {
        if (baseType != null)
            return baseType.getName();
        else
            return null;
    }

    @JsonIgnore
    public boolean isRootType() {
        return baseType == null;
    }

    @Override
    public String toString() {
        return "EntityType{" +
                "baseType=" + baseType +
                ", namespace='" + namespace + '\'' +
                ", declaredProperties=" + declaredProperties +
                ", name='" + name + '\'' +
                '}';
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityType)) return false;

        EntityType that = (EntityType) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (namespace != null ? !namespace.equals(that.namespace) : that.namespace != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = namespace != null ? namespace.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private List<? extends PropertyBaseItem> declaredProperties;
        private String namespace;
        private EntityType baseType;
        private String label;
        private String description;
        private String tableName;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder declaredProperties(List<? extends PropertyBaseItem> declaredProperties) {
            this.declaredProperties = declaredProperties;
            return this;
        }

        public Builder namespace(String namespace) {
            this.namespace = namespace;
            return this;
        }

        public Builder baseType(EntityType baseType) {
            this.baseType = baseType;
            return this;
        }

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public EntityType build() {
            return new EntityType(name, namespace, declaredProperties, label, description, tableName, baseType);
        }
    }
}
