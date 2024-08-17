package com.example.cardealer.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CarService {

  void seedCars() throws JAXBException, FileNotFoundException;
}
