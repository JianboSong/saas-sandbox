package com.acxiom.platform.saas.utils.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

//import org.codehaus.jackson.JsonGenerator;
//import org.codehaus.jackson.JsonProcessingException;
//import org.codehaus.jackson.map.JsonSerializer;
//import org.codehaus.jackson.map.SerializerProvider;

public class UserSerializer
        extends JsonSerializer<Map<String, String>>
{
    @Override
    public void serialize(Map<String, String> m, JsonGenerator jg, SerializerProvider sp)
            throws IOException, JsonProcessingException
    {
        jg.writeStartObject();
        Iterator i = m.keySet().iterator();
        while (i.hasNext()) {
            Object key = i.next();
            jg.writeObjectField(key.toString(), m.get(key));
        }
        jg.writeEndObject();
    }

}