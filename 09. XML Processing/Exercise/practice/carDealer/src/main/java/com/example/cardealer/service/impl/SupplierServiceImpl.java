package com.example.cardealer.service.impl;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.repository.SupplierRepository;
import com.example.cardealer.service.SupplierService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
  private final SupplierRepository supplierRepository;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;

  public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
    this.supplierRepository = supplierRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
  }

  @Override
  public void seedSuppliers() {

  }
}
