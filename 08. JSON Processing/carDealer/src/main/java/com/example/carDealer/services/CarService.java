package com.example.carDealer.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CarService {
    void seedCar() throws IOException, JAXBException;

    void getCarByMake() throws JAXBException;

    void getCarsWithParts() throws JAXBException;
}
