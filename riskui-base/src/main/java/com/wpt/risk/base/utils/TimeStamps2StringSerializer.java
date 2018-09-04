package com.wpt.risk.base.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamps2StringSerializer extends JsonSerializer<Long> {


    @Override
    public void serialize(Long date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        long dt = date * 1000L;
        Date d = new Date(dt);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(d);
        jsonGenerator.writeString(dateStr);
    }
}