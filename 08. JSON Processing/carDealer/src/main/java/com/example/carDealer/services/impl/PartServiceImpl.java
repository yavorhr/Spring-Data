package com.example.carDealer.services.impl;

import com.example.carDealer.domain.dtos.seedDataDtos.PartImportDto;
import com.example.carDealer.domain.dtos.seedDataDtos.PartImportRootDto;
import com.example.carDealer.domain.entities.Part;
import com.example.carDealer.domain.entities.Supplier;
import com.example.carDealer.domain.repositories.PartRepository;
import com.example.carDealer.domain.repositories.SupplierRepository;
import com.example.carDealer.services.PartService;
import com.example.carDealer.utils.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private final static String PART_PATH = "src/main/resources/xmls/parts.xml";
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final SupplierRepository supplierRepository;
    private final XmlParser xmlParser;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, Gson gson, SupplierRepository supplierRepository, XmlParser xmlParser) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedPart() throws Exception {
        PartImportRootDto partImportRootDto = this.xmlParser.parseXml(PartImportRootDto.class, PART_PATH);

        for (PartImportDto partDto : partImportRootDto.getParts()) {
            Part map = this.modelMapper.map(partDto, Part.class);
            map.setSupplier(getRandomSupplier());
            this.partRepository.saveAndFlush(map);
        }

    }

    private Supplier getRandomSupplier() throws Exception {
        Random random = new Random();
        long index = (long) random.nextInt((int) this.supplierRepository.count()) + 1;

        Optional<Supplier> supplier = this.supplierRepository.findById(index);
        if (supplier.isPresent()) {
            return supplier.get();
        } else {
            throw new Exception("Supplier don't exist");
        }
    }
}
