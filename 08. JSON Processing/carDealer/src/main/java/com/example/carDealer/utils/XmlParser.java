package com.example.carDealer.utils;

import javax.xml.bind.JAXBException;
import java.awt.*;

public interface XmlParser {

   <O> O parseXml(Class<O> object, String filePath) throws JAXBException;

   <O> void exportXml(O object, Class<O> objectClass,String filePath) throws JAXBException;
}
