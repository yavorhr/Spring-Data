package com.example.carDealer.services.impl;

import com.example.carDealer.domain.dtos.seedDataDtos.CustomerImportDto;
import com.example.carDealer.domain.dtos.seedDataDtos.CustomerRootDto;
import com.example.carDealer.domain.dtos.views.CustomerExportDto;
import com.example.carDealer.domain.dtos.views.CustomerExportRootDto;

import com.example.carDealer.domain.dtos.views.SalesCustomerDto;
import com.example.carDealer.domain.dtos.views.SalesCustomerRootDto;
import com.example.carDealer.domain.entities.Customer;
import com.example.carDealer.domain.entities.Part;
import com.example.carDealer.domain.entities.Sale;
import com.example.carDealer.domain.repositories.CustomerRepository;
import com.example.carDealer.services.CustomerService;
import com.example.carDealer.utils.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static String CUSTOMER_PATH = "src/main/resources/xmls/customers.xml";
    private final static String EXPORT_CUSTOMER_PATH = "src/main/resources/xmls/exported/orderedCustomers.xml";
    private final static String EXPORT_CUSTOMER_SALES_PATH = "src/main/resources/xmls/exported/customerSales.xml";
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson, XmlParser xmlParser) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCustomers() throws IOException, JAXBException {

        CustomerRootDto customerRootDto = this.xmlParser.parseXml(CustomerRootDto.class, CUSTOMER_PATH);

        for (CustomerImportDto customer : customerRootDto.getCustomers()) {
            this.customerRepository.saveAndFlush(this.modelMapper.map(customer, Customer.class));
        }
    }

    @Override
    public void orderedCustomers() throws JAXBException {
        List<CustomerExportDto> dtos = this.customerRepository.getAllByOrderByBirthDateAscYoungDriverAsc()
                .stream()
                .map(c -> this.modelMapper.map(c, CustomerExportDto.class))
                .collect(Collectors.toList());
        CustomerExportRootDto rootDto = new CustomerExportRootDto();
        rootDto.setCustomers(dtos);

        this.xmlParser.exportXml(rootDto,CustomerExportRootDto.class,EXPORT_CUSTOMER_PATH);

    }

    @Override
    public void getAllWithBoughtCars() throws JAXBException {
        List<SalesCustomerDto> salesCustomerDtos = new ArrayList<>();

        this.customerRepository.getAllByBoughtCars().forEach(c -> {
            SalesCustomerDto customerDto = this.modelMapper.map(c,SalesCustomerDto.class);
            customerDto.setBoughtCars(c.getSales().size());
            double price = 0;
            for (Sale sale : c.getSales()) {
                for (Part part : sale.getCar().getParts()) {
                    price += Double.parseDouble(String.valueOf(part.getPrice()));
                }
            }
            customerDto.setSpentMoney(BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP));
            salesCustomerDtos.add(customerDto);
        });

        SalesCustomerRootDto salesCustomerRootDto = new SalesCustomerRootDto();
        salesCustomerRootDto.setCustomers(salesCustomerDtos);
        this.xmlParser.exportXml(salesCustomerRootDto,SalesCustomerRootDto.class,EXPORT_CUSTOMER_SALES_PATH);
    }

}
