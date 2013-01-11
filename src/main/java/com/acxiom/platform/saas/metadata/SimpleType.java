package com.acxiom.platform.saas.metadata;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

import com.google.common.collect.*;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import com.google.common.collect.Iterables;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 1/9/13
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleType<V> extends Type{


    private static Set<SimpleType<?>> all = new HashSet<SimpleType<?>>();

    // http://msdn.microsoft.com/en-us/library/bb399213.aspx
    public static final SimpleType<byte[]> BINARY = newSimple("Binary", byte[].class, Byte[].class);
    public static final SimpleType<Boolean> BOOLEAN = newSimple("Boolean", Boolean.class, boolean.class);
    public static final SimpleType<LocalDateTime> DATETIME = newSimple("DateTime", LocalDateTime.class, Instant.class, Date.class, Calendar.class, Timestamp.class, java.sql.Date.class); // possible, but not default: Time.class
    public static final SimpleType<DateTime> DATETIMEOFFSET = newSimple("DateTimeOffset", DateTime.class);
    public static final SimpleType<BigDecimal> DECIMAL = newSimple("Decimal", BigDecimal.class);
    public static final SimpleType<Double> DOUBLE = newSimple("Double", Double.class, double.class);
    public static final SimpleType<Short> INT16 = newSimple("Int16", Short.class, short.class);
    public static final SimpleType<Integer> INT32 = newSimple("Int32", Integer.class, int.class);
    public static final SimpleType<Long> INT64 = newSimple("Int64", Long.class, long.class);
    public static final SimpleType<Byte> SBYTE = newSimple("SByte", Byte.class, byte.class);
    public static final SimpleType<Float> SINGLE = newSimple("Single", Float.class, float.class);
    public static final SimpleType<String> STRING = newSimple("String", String.class, char.class, Character.class);
    public static final SimpleType<LocalTime> TIME = newSimple("Time", LocalTime.class, Time.class); // possible, but not default: Date.class, Calendar.class, Timestamp.class

    private static <V> SimpleType<V> newSimple(String typeString, Class<V> canonicalJavaType, Class<?>... alternateJavaTypes) {
        SimpleType<V> rt = new SimpleType<V>(typeString, canonicalJavaType, alternateJavaTypes);
        all.add(rt);
        return rt;
    }

    /**
     * Immutable set of all simple types.
     */
    public static final ImmutableSet<SimpleType<?>> ALL =  ImmutableSet.copyOf(all);

    private final Class<V> canonicalJavaType;
    private final List<Class<?>> javaTypes;

    private SimpleType(String fullyQualifiedTypeName, Class<V> canonicalJavaType, Class<?>... alternateJavaTypes) {
        super(fullyQualifiedTypeName);
        this.canonicalJavaType = canonicalJavaType;
        this.javaTypes= Lists.asList(canonicalJavaType, alternateJavaTypes);
    }

    @Override
    public boolean isSimple() {
        return true;
    }

    public Class<V> getCanonicalJavaType() {
        return canonicalJavaType;
    }

    /**
     * Gets all java-types associated with this edm-type.
     *
     * @return the associated java-types.
     */
    public List<Class<?>> getJavaTypes() {
        return javaTypes;
    }

    /**
     * Finds the edm simple type for a given java-type.
     *
     * @param javaType  the java-type
     * @return the associated edm simple type, else null
     */
    @SuppressWarnings("unchecked")
    public static <V> SimpleType<V> forJavaType(Class<?> javaType) {
        for (SimpleType<?> simple : ALL)
            if (simple.getJavaTypes().contains(javaType))
                return (SimpleType<V>) simple;
        return null;
    }

    public static Type.Builder<?, ?> newBuilder(Type type) {
        return new Builder(type);
    }

    private static class Builder extends Type.Builder<Type, Builder> {

        private Builder(Type type) {
            super(type);
        }

        @Override
        Builder newBuilder(Type type) {
            return new Builder(type);
        }

        @Override
        public Type build() {
            return (Type) _build();
        }

        @Override
        protected Type buildImpl() {
            // should never get here
            return null;
        }

    }


}
