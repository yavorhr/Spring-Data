package com.example.carDealer.services;

import javax.xml.bind.JAXBException;

public interface SaleService {
    void seedSale();

    void getSalesWithAndWithoutDiscount() throws JAXBException;
}
