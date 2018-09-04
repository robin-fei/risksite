package com.wpt.risk.base.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class JacksonValueAssignEnumerationDeserializer<T, E extends ValueAsignEnumeration<T, E>> extends JsonDeserializer<E> implements ContextualDeserializer {

    private E target;

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        Class<E> clazz = (Class<E>) deserializationContext.getContextualType().getRawClass();
        target = clazz.getEnumConstants()[0];
        return this;
    }

    @Override
    public E deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        if (node == null) {
            return null;
        }

        String text = node.asText();

        if (StringUtils.isBlank(text)) {
            return null;
        }

        return target.fromJSON(text);
    }
}