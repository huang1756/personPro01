package com.hyq.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;


/**
 * Created by Lezc on 8/12/15.
 */
public class MyObjectWrapper extends ObjectMapper {

    public MyObjectWrapper() {

        super();
        this.enable(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });
    }
}
