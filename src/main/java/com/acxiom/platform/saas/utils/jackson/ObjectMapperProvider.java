package com.acxiom.platform.saas.utils.jackson;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.MapperFeature;

/**
 * Created with IntelliJ IDEA.
 * User: alvhom
 * Date: 2/14/13
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ObjectMapperProvider extends JacksonJaxbJsonProvider {

    private ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        super();
        objectMapper = new ObjectMapper();
        //objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, false);
        //objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, false);
        objectMapper.enable(MapperFeature.USE_ANNOTATIONS);
        objectMapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        setMapper(objectMapper);
    }

    /*
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
    */

}
