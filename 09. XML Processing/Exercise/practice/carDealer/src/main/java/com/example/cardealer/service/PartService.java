package com.example.cardealer.service;

import com.example.cardealer.model.entity.Part;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Set;

public interface PartService {

  void seedParts() throws JAXBException, FileNotFoundException;

  Set<Part> findRandomParts();
}
