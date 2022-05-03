package com.example.carDealer.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CustomerService {
    void seedCustomers() throws IOException, JAXBException;

    void orderedCustomers() throws JAXBException;

    void getAllWithBoughtCars() throws JAXBException;
}
