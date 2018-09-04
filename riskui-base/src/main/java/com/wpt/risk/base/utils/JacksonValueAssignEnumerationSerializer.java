package com.wpt.risk.base.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fong
 */
public class JacksonValueAssignEnumerationSerializer extends JsonSerializer<ValueAsignEnumeration> {

    ObjectMapper mapper;

    public JacksonValueAssignEnumerationSerializer() {
        mapper = new ObjectMapper();
    }

    public JacksonValueAssignEnumerationSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void serialize(ValueAsignEnumeration value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (value != null) {
            map.put("code", value.codeVal());
            map.put("name", value.strVal());
            mapper.writeValue(gen, map);
        }
        /*
        gen.writeStartObject();
        gen.writeFieldName("code");
        gen.writeNumber(value.intVal());
        gen.writeFieldName("name");
        gen.writeString(value.strVal());
        gen.writeEndObject();
        */
    }
}
