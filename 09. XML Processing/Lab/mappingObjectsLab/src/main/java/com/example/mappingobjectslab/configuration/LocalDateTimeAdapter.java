package com.example.mappingobjectslab.configuration;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(
                v.trim(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return v.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
