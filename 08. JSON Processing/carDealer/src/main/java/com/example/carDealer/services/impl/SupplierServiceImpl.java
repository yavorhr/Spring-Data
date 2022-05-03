package com.example.carDealer.services.impl;

import com.example.carDealer.domain.dtos.seedDataDtos.SupplierImportDto;
import com.example.carDealer.domain.dtos.seedDataDtos.SupplierImportRootDto;
import com.example.carDealer.domain.dtos.views.SupplierNotImportDto;
import com.example.carDealer.domain.dtos.views.SupplierNotImportRootDto;
import com.example.carDealer.domain.entities.Supplier;
import com.example.carDealer.domain.repositories.SupplierRepository;
import com.example.carDealer.services.SupplierService;
import com.example.carDealer.utils.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final static String SUPPLIER_PATH = "src/main/resources/xmls/suppliers.xml";
    private final static String EXPORT_SUPPLIER_PATH = "src/main/resources/xmls/exported/suppliers.xml";
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson, XmlParser xmlParser) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSupplier() throws IOException, JAXBException {
        SupplierImportRootDto supplierImportRootDto = xmlParser.parseXml(SupplierImportRootDto.class, SUPPLIER_PATH);

        supplierImportRootDto.getSuppliers().forEach(s -> {
            this.supplierRepository.saveAndFlush(this.modelMapper.map(s, Supplier.class));
        });
    }

    @Override
    public void getAllSuppliers() throws JAXBException {
        List<SupplierNotImportDto> dto = new ArrayList<>();
        this.supplierRepository.findAllByImporter(false).forEach(s -> {
            SupplierNotImportDto supplier = this.modelMapper.map(s, SupplierNotImportDto.class);
            supplier.setPartsSize(s.getParts().size());
            dto.add(supplier);
        });
        SupplierNotImportRootDto s = new SupplierNotImportRootDto();
        s.setSuppliers(dto);
        this.xmlParser.exportXml(s,SupplierNotImportRootDto.class,EXPORT_SUPPLIER_PATH);
    }
}
