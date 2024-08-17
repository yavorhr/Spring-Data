package com.example.cardealer.service.impl;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.seed.CustomersRootDto;
import com.example.cardealer.model.entity.Customer;
import com.example.cardealer.repository.CustomerRepository;
import com.example.cardealer.service.CustomerService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
  private final CustomerRepository customerRepository;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;

  public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
    this.customerRepository = customerRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
  }

  @Override
  public void seedCustomers() throws JAXBException, FileNotFoundException {
    if (this.customerRepository.count() > 0) {
      return;
    }

    CustomersRootDto rootDto =
            this.xmlParser.fromFile(ProjectConstants.SEED_CUSTOMERS, CustomersRootDto.class);

    rootDto.getCustomers()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> this.modelMapper.map(dto, Customer.class))
            .forEach(this.customerRepository::save);
  }

  @Override
  public Customer findRandomCustomer() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.customerRepository.count()+1);
    return this.customerRepository.findById(randomId).orElse(null);
  }
}
