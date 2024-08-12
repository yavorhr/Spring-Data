package com.example.shop.service;

import com.example.shop.model.dto.view.FirstQuery.ProductsViewRootDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface ProductService {

  void seedProducts() throws JAXBException, FileNotFoundException;

  ProductsViewRootDto findProductsInRangeWithoutBuyer();
}
