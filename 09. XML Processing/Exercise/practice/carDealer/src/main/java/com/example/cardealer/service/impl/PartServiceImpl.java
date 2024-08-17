package com.example.cardealer.service.impl;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.seed.PartsRootDto;
import com.example.cardealer.model.entity.Part;
import com.example.cardealer.repository.PartRepository;
import com.example.cardealer.service.PartService;
import com.example.cardealer.service.SupplierService;
import com.example.cardealer.util.ValidationUtil;
import com.example.cardealer.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Service
public class PartServiceImpl implements PartService {
  private final PartRepository partRepository;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final XmlParser xmlParser;
  private final SupplierService supplierService;

  public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, SupplierService supplierService) {
    this.partRepository = partRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.xmlParser = xmlParser;
    this.supplierService = supplierService;
  }

  @Override
  public void seedParts() throws JAXBException, FileNotFoundException {
    if (this.partRepository.count() > 0) {
      return;
    }

    PartsRootDto rootDto =
            this.xmlParser.fromFile(ProjectConstants.SEED_PARTS, PartsRootDto.class)
            ;
    rootDto.getParts()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> {
              Part entity = this.modelMapper.map(dto, Part.class);
              entity.setSupplier(this.supplierService.findRandomSupplier());

              return entity;
            })
            .forEach(this.partRepository::save);
  }
}
