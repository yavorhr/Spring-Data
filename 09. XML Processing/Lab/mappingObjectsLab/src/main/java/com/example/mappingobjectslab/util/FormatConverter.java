package com.example.mappingobjectslab.util;

import com.example.objectmapping.exception.UnableToConvertException;

public interface FormatConverter {

    void setPrettyPrint();

    String serialize(Object obj) throws UnableToConvertException;

    void serialize(Object obj, String fileName);


    <T> T deserialize(String input, Class<T> toType);

    <T> T deserializeFromFile(String fileName, Class<T> toType);
}
