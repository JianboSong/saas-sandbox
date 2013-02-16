package com.acxiom.platform.saas.metadata;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;



/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/7/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Property extends PropertyBaseItem {

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
    private final String columnName;
    private final String displayFormat;
    private final boolean isUnique;
    private final boolean isIndexed;
    private final boolean isKey;
    private final boolean autoIncrement;
    private final boolean userVisible;

    /*
"Kind": "/DataServices/MarketingCloud/kind/Field",
"Path": "/DataServices/MarketingCloud/Templates/Tables/ACCOUNT",
"Artifact": "",
"ColumnName": "UNSUB_POSTAL_FLG",
"DefaultValue": "0",
"Description": "",
"DisplayFormat": "",
"Unique": "FALSE",
"Indexed": "FALSE",
"Key": "FALSE",
"FullName": "UNSUB_POSTAL_FLG",
"Label": "",
"Type": "tinyint",
"Length": ,
"Required": "FALSE",
"AutoIncrement": "FALSE",
"UserVisable": "TRUE"
*/
    @JsonCreator
    public Property(
            @JsonProperty("name") String name,
            @JsonProperty("columnName") String columnName,
            @JsonProperty("defaultValue") String defaultValue,
            @JsonProperty("description") String description,
            @JsonProperty("displayFormat") String displayFormat,
            @JsonProperty("unique") boolean isUnique,
            @JsonProperty("indexed") boolean isIndexed,
            @JsonProperty("key") boolean isKey,
            @JsonProperty("fullName") String fullName,
            @JsonProperty("label") String label,
            @JsonProperty("type") String type,
            @JsonProperty("length") Integer maxLength,
            @JsonProperty("required") boolean nullable,
            @JsonProperty("autoIncrement") boolean autoIncrement,
            @JsonProperty("userVisible") boolean userVisible,
            @JsonProperty("precision") int precision,
            @JsonProperty("scale") int scale
) {
        this(name, columnName, defaultValue, description, displayFormat, isUnique, isIndexed, isKey, fullName, label, maxLength, nullable, autoIncrement,
                userVisible, precision, scale, null, Type.getSimple(type));
    }

    @JsonIgnore
    public Property(
            String name,
            String columnName,
            String defaultValue,
            String description,
            String displayFormat,
            boolean isUnique,
            boolean isIndexed,
            boolean isKey,
            String fullName,
            String label,
            int maxLength,
            boolean nullable,
            boolean autoIncrement,
            boolean userVisible,
            int precision,
            int scale,
            EntityType declaringType,
            Type type) {
        this.name = name;
        this.columnName = columnName;
        this.description = description;
        this.displayFormat = displayFormat;
        this.isUnique = isUnique;
        this.isKey = isKey;
        this.isIndexed = isIndexed;
        this.autoIncrement = autoIncrement;
        this.userVisible=userVisible;
        this.declaringType = declaringType;
        this.type = type;
        this.nullable = nullable;
        this.maxLength = maxLength;
        this.defaultValue = defaultValue;
        this.precision = precision;
        this.scale = scale;
        this.label = label;


        Preconditions.checkNotNull(this.name, "Name must be specified");
        Preconditions.checkNotNull(this.type, "Type must be specified");
    }

    @JsonIgnore
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public String getTypeName() {
        return type.getFullyQualifiedTypeName();
    }

    @JsonProperty("required")
    public boolean isNullable() {
        return nullable;
    }

    @JsonProperty("length")
    public Integer getMaxLength() {
        return maxLength;
    }

    @JsonProperty
    public String getDefaultValue() {
        return defaultValue;
    }

    @JsonProperty
    public int getPrecision() {
        return precision;
    }

    @JsonProperty
    public int getScale() {
        return scale;
    }

    @JsonProperty
    public String getLabel() {
        return label;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public EntityType getDeclaringType() {

        return declaringType;
    }

    @JsonProperty("autoIncrement")
    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    @JsonProperty("columnName")
    public String getColumnName() {
        return columnName;
    }

    @JsonProperty("displayFormat")
    public String getDisplayFormat() {
        return displayFormat;
    }

    @JsonProperty ("indexed")
    public boolean isIndexed() {
        return isIndexed;
    }

    @JsonProperty
    public boolean isKey() {
        return isKey;
    }

    @JsonProperty
    public boolean isUnique() {
        return isUnique;
    }

    @JsonProperty
    public boolean isUserVisible() {
        return userVisible;
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
        private String columnName;
        private String displayFormat;
        private boolean isUnique;
        private boolean isKey;
        private boolean autoIncrement;
        private boolean isIndexed;
        private boolean userVisible;

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

        public Builder columnName(String columnName) {
            this.columnName = columnName;
            return this;
        }

        public Builder isKey(boolean isKey) {
            this.isKey = isKey;
            return this;
        }

        public Builder isUnique(boolean isUnique) {
            this.isUnique = isUnique;
            return this;
        }


        public Builder maxLength(int maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder autoIncrement(boolean autoIncrement) {
            this.autoIncrement = autoIncrement;
            return this;
        }

        public Builder isIndexed(boolean isIndexed) {
            this.isIndexed = isIndexed;
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

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder displayFormat(String displayFormat) {
            this.displayFormat= displayFormat;
            return this;
        }

        public Property build() {
            // check any preconditions here

            return new Property(
                    name,
                    columnName,
                    defaultValue,
                    description,
                    displayFormat,
                    isUnique,
                    isIndexed,
                    isKey,
                    name,
                    label,
                    maxLength,
                    nullable,
                    autoIncrement,
                    userVisible,
                    precision,
                    scale,
                    declaringType,
                    type
            );

            /*
                        String name,
            String columnName,
            String defaultValue,
            String description,
            String displayFormat,
            boolean isUnique,
            boolean isIndexed,
            boolean isKey,
            String fullName,
            String label,
            int maxLength,
            boolean nullable,
            boolean autoIncrement,
            boolean userVisible,
            int precision,
            int scale,
            EntityType declaringType,
            Type type)
             */
        }
    }

}
