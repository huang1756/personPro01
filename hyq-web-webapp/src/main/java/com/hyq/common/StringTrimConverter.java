package com.hyq.common;


import org.springframework.core.convert.converter.Converter;

public class StringTrimConverter implements Converter<String, String> {
    public StringTrimConverter() {
    }

    public String convert(String source) {
        return null == source?null:source.trim();
    }
}

