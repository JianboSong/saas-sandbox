package com.acxiom.platform.saas.metadata;

import com.acxiom.platform.saas.metadata.repository.MetaResolver;
import com.acxiom.platform.saas.metadata.repository.RootResolver;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 2/15/13
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class RelationshipProperty extends PropertyBaseItem {

    private final String name;
    private final String label;
    private final String description;

    private final EntityType targetEntity;
    private final int relationshipKind;
    private final List<String> joinColumns;

    private final boolean userVisible;


    @JsonCreator
    public RelationshipProperty (
        @JsonProperty("name")  String name,
        @JsonProperty("label") String label,
        @JsonProperty("description") String description,
        @JsonProperty("joinColumns") List<String> joinColumns,
        @JsonProperty("kind")  int relationshipKind,
        @JsonProperty("target-entity") String targetEntityName) {
            this(name, label, description, joinColumns, relationshipKind, getMetaResolver().resolve(targetEntityName));
    }


    @JsonIgnore
    public RelationshipProperty (
            String name,
            String label,
            String description,
            List<String> joinColumns,
            int relationshipKind,
            EntityType targetEntity) {
        super();
        this.name = name;
        this.label = label;
        this.description = description;
        this.joinColumns = joinColumns;
        this.targetEntity = targetEntity;
        this.relationshipKind = relationshipKind;
        this.userVisible = true;
    }

    public static MetaResolver getMetaResolver() {
        return RootResolver.getInstance();
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public List<String> getJoinColumns() {
        return joinColumns;
    }

    @JsonProperty
    public String getLabel() {
        return label;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public int getRelationshipKind() {
        return relationshipKind;
    }

    @JsonProperty("targetEntity")
    public String getTargetEntityName() {
        return getTargetEntity().getName();
    }

    @JsonIgnore
    public EntityType getTargetEntity() {
        return targetEntity;
    }

    @JsonIgnore
    public boolean isUserVisible() {
        return userVisible;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private  String name;
        private  String label;
        private  String description;
        private  EntityType targetEntity;
        private  int relationshipKind;
        private  List<String> joinColumns;

        private  boolean userVisible;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder label(String label) {
            this.label=label;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder targetEntity(EntityType entity) {
            this.targetEntity = entity;
            return this;
        }

        public Builder targetEntityName(String entityName) {
            if (entityName != null)
                targetEntity = getMetaResolver().resolve(entityName);
            return this;
        }

        public Builder relationshipKind(int kind) {
            this.relationshipKind = kind;
            return this;
        }

        public Builder joinColumns(List<String> columns) {
            this.joinColumns = columns;
            return this;
        }

        public Builder userVisble(boolean flag) {
            this.userVisible = flag;
            return this;
        }

        public RelationshipProperty build() {
            // check any preconditions here

            return new RelationshipProperty(
                    name,
                    label,
                    description,
                    joinColumns,
                    relationshipKind,
                    targetEntity
            );

        }
    }

}
