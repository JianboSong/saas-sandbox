package com.acxiom.platform.saas.metadata;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/7/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Property extends Item {

    private final EntityType declaringType;
    private final Type type;
    private final boolean nullable;
    private final Integer maxLength;
    private final String defaultValue;
    private final int precision;
    private final int scale;
    private final String label;
    private final String description;
    private final String name;


    public Property(String name, EntityType declaringType, Type type, boolean nullable, Integer maxLength, String defaultValue, int precision, int scale, String label, String description) {
        this.name = name;
        this.declaringType = declaringType;
        this.type = type;
        this.nullable = nullable;
        this.maxLength = maxLength;
        this.defaultValue = defaultValue;
        this.precision = precision;
        this.scale = scale;
        this.label = label;
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public boolean isNullable() {
        return nullable;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public int getPrecision() {
        return precision;
    }

    public int getScale() {
        return scale;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public EntityType getDeclaringType() {

        return declaringType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;

        Property property = (Property) o;

        if (name != null ? !name.equals(property.name) : property.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Property{" +
                "declaringType=" + declaringType +
                ", type=" + type +
                ", nullable=" + nullable +
                ", maxLength=" + maxLength +
                ", defaultValue='" + defaultValue + '\'' +
                ", precision=" + precision +
                ", scale=" + scale +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private EntityType declaringType;
        private Type type;
        private boolean nullable;
        private Integer maxLength;
        private String defaultValue;
        private int precision;
        private int scale;
        private String label;
        private String description;
        private String name;

        public Builder() {
            this.maxLength=-1;
            this.precision=-1;
            this.scale=-1;
            this.nullable = false;
        }

        public Builder(Property property) {
            this.name = property.name;
            this.declaringType=property.getDeclaringType();
            this.type=property.getType();
            this.nullable = property.isNullable();
            this.maxLength = property.getMaxLength();
            this.defaultValue = property.getDefaultValue();
            this.precision = property.getPrecision();
            this.scale = property.getScale();
            this.label = property.getLabel();
            this.description = property.getDescription();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder declaringType(EntityType declaringType) {
            this.declaringType = declaringType;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder nullable(boolean nullable) {
            this.nullable = nullable;
            return this;
        }

        public Builder maxLength(int maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder defaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder precision(int precision) {
            this.precision = precision;
            return this;
        }

        public Builder scale(int scale) {
            this.scale = scale;
            return this;
        }

        public Builder lable(String label) {
            this.label = label;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Property build() {
            // check any preconditions here

            return new Property(
                    name,
                    declaringType,
                    type,
                    nullable,
                    maxLength,
                    defaultValue,
                    precision,
                    scale,
                    label,
                    description
            );
        }
    }

}
