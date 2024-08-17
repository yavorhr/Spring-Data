package com.example.cardealer.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface PartService {

  void seedParts() throws JAXBException, FileNotFoundException;
}
