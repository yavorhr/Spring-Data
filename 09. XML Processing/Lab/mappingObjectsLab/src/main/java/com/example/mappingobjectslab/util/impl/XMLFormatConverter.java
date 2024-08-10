package com.example.mappingobjectslab.util.impl;

import com.example.mappingobjectslab.util.FormatConverter;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Component;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component("xml_format_converter")
public class XMLFormatConverter implements FormatConverter {

    private Map<String, Marshaller> marshallers = new HashMap<>();

    private boolean prettyPrint = false;

    @Override
    public void setPrettyPrint() {
        this.prettyPrint = true;
    }

    @Override
    public String serialize(Object obj) throws UnableToConvertException {
        try {


            StringWriter sw = new StringWriter();

            this.getMarshaller(obj).marshal(
                    obj,
                    sw
            );

            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new UnableToConvertException();
        }
    }

    @Override
    public void serialize(Object obj, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);

            this.getMarshaller(obj).marshal(
                    obj,
                    fw
            );
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T deserialize(String input, Class<T> toType) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

            return (T) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T deserializeFromFile(String fileName, Class<T> toType) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(toType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();


            return (T) unmarshaller.unmarshal(new FileInputStream(fileName));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Marshaller getMarshaller(Object obj) {
        try {
            if (this.marshallers.containsKey(obj.getClass().getName())) {
                return this.marshallers.get(obj.getClass().getName());
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, this.prettyPrint);

            this.marshallers.put(
                    obj.getClass().getName(),
                    marshaller
            );

            return marshaller;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
