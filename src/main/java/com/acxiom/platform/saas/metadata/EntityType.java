package com.acxiom.platform.saas.metadata;

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
    private final List<Property> declaredProperties;
    private final String name;
    private EntityType baseType;

    public EntityType(String name, List<Property> declaredProperties, String namespace, EntityType baseType) {
        this.name = name;
        this.declaredProperties = declaredProperties;
        this.namespace = namespace;
        this.baseType = baseType;
    }

    public String getNamespace() {
        return namespace;
    }

    public List<Property> getDeclaredProperties() {
        return declaredProperties;
    }

    public List<Property> getKeys() {
        // return key properties
        return declaredProperties;
    }

    public EntityType getBaseType() {
        return baseType;
    }

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
        private List<Property> declaredProperties;
        private String namespace;
        private EntityType baseType;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder declaredProperties(List<Property> declaredProperties) {
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

        public EntityType build() {
            return new EntityType(name, declaredProperties, namespace, baseType);
        }
    }
}
