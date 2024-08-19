package com.example.cardealer.service.impl;

import com.example.cardealer.constant.ProjectConstants;
import com.example.cardealer.model.dto.seed.SupplierRootDto;
import com.example.cardealer.model.dto.view.ThirdQuery.SupplierIdNamePartsCountViewDto;
import com.example.cardealer.model.dto.view.ThirdQuery.SuppliersViewRootDto;
import com.example.cardealer.model.entity.Supplier;
import com.example.cardealer.repository.SupplierRepository;
import com.example.cardealer.service.SupplierService;
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
  public void seedSuppliers() throws JAXBException, FileNotFoundException {
    if (this.supplierRepository.count() > 0) {
      return;
    }

    SupplierRootDto rootDto =
            this.xmlParser.fromFile(ProjectConstants.SEED_SUPPLIERS, SupplierRootDto.class);

    rootDto
            .getSuppliers()
            .stream()
            .filter(this.validationUtil::isValid)
            .map(dto -> this.modelMapper.map(dto, Supplier.class))
            .forEach(this.supplierRepository::save);
  }

  @Override
  public Supplier findRandomSupplier() {
    long randomId = ThreadLocalRandom.current().nextLong(1, this.supplierRepository.count() + 1);
    return this.supplierRepository.findById(randomId).orElse(null);
  }

  @Override
  public SuppliersViewRootDto findAllLocalSuppliers() {
    var rootDto = new SuppliersViewRootDto();

    List<SupplierIdNamePartsCountViewDto> innerDto = this.supplierRepository
            .findAllByImporterFalse()
            .stream()
            .map(e -> {
              var dto =
                      this.modelMapper.map(e, SupplierIdNamePartsCountViewDto.class);
              dto.setPartsCount(e.getParts().size());
              return dto;
            })
            .collect(Collectors.toList());

    rootDto.setSuppliers(innerDto);
    return rootDto;
  }
}