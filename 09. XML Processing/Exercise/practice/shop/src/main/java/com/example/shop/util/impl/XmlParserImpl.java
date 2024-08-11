package com.example.shop.util.impl;

import com.example.shop.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlParserImpl implements XmlParser {
  private JAXBContext jaxbContext;

  @SuppressWarnings("unchecked")
  @Override
  public <T> T fromFile(String filePath, Class<T> dtoClass) throws JAXBException, FileNotFoundException {
    jaxbContext = JAXBContext.newInstance(dtoClass);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    return (T) unmarshaller.unmarshal(new FileReader(filePath));
  }

  @Override
  public <T> void writeToFile(String filePath, T dto) throws JAXBException {
    jaxbContext = JAXBContext.newInstance(dto.getClass());
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    marshaller.marshal(dto,new File(filePath));
  }
}
