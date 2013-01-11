package com.acxiom.platform.saas.metadata;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/9/13
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/**
 * A type in the metadata system.
 *
 */
public abstract class Type extends Item {

    public static  <K, V> Map<K, V> toMap(Set<V> values, Function<V, K> keyFn) {
        Map<K, V> rt = new HashMap<K, V>();
        for (V value : values) {
            rt.put(keyFn.apply(value), value);
        }
        return rt;
    }

    private static class LazyInit {
        private static final Map<String, SimpleType<?>> POOL = toMap(SimpleType.ALL,
                new Function<SimpleType<?>, String>() {
                    @Override
                    public String apply(SimpleType<?> t) {
                        return t.getFullyQualifiedTypeName();
                    }
                });
    }

    private final String fullyQualifiedTypeName;


    protected Type(String fullyQualifiedTypeName) {
        super();
        this.fullyQualifiedTypeName = fullyQualifiedTypeName;
    }

    /**
     * Gets an edm-type for a given type name.
     *
     * @param fullyQualifiedTypeName  the fully-qualified type name
     * @return the edm-type
     */
    public static SimpleType<?> getSimple(String fullyQualifiedTypeName) {
        if (fullyQualifiedTypeName == null)
            return null;
        SimpleType<?> simpleType = LazyInit.POOL.get(fullyQualifiedTypeName);
        if (simpleType == null && !fullyQualifiedTypeName.contains(".")) // allow "string, Int32" for old dallas service functions
            for (SimpleType<?> simpleTypeInPool : LazyInit.POOL.values())
                if (simpleTypeInPool.getFullyQualifiedTypeName().equalsIgnoreCase("Edm." + fullyQualifiedTypeName))
                    return simpleTypeInPool;
        return simpleType;
    }

    /**
     * Gets the fully-qualified type name for this edm-type.
     */
    public String getFullyQualifiedTypeName() {
        return this.fullyQualifiedTypeName;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), getFullyQualifiedTypeName());
    }

    @Override
    public int hashCode() {
        return this.fullyQualifiedTypeName.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Type && ((Type) other).fullyQualifiedTypeName.equals(this.fullyQualifiedTypeName);
    }

    public abstract boolean isSimple();

    /** Mutable builder for {@link Type} objects. */
    public abstract static class Builder<T, TBuilder>  {

        private Type builtType = null;

        public Builder() {}

        public Builder(Type type) {
            this.builtType = type;
        }

        abstract TBuilder newBuilder(T item);

        public abstract Type build();

        protected final Type _build() {
            if (builtType == null) {
                builtType = buildImpl();
            }
            return builtType;
        }

        protected abstract Type buildImpl();

    }

}

