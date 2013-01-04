package com.acxiom.platform.saas.utils.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserDeserializer extends JsonDeserializer<Map<String, String>> {

    @Override
    public Map<String, String> deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
        HashMap map = new HashMap<String, String>();

        jp.nextToken();
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String namefield = jp.getCurrentName();
            String textcontent = jp.getText();
            map.put(namefield, textcontent);
        }
        return map;
    }
}
