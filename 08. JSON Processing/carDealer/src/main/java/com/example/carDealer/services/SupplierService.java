package com.example.carDealer.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SupplierService {

    void seedSupplier() throws IOException, JAXBException;

    void getAllSuppliers() throws JAXBException;
}
