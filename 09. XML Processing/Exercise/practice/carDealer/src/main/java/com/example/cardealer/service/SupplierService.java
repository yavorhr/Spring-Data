package com.example.cardealer.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SupplierService {

    void seedSuppliers() throws JAXBException, FileNotFoundException;
}
