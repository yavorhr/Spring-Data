package com.example.cardealer_practice.model.service.impl;

import com.example.cardealer_practice.constant.ProjectConstants;
import com.example.cardealer_practice.model.repository.PartRepository;
import com.example.cardealer_practice.model.service.PartService;
import com.example.cardealer_practice.model.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PartServiceImpl implements PartService {
  private final PartRepository partRepository;
  private final ModelMapper modelMapper;
  private final Gson gson;
  private final ValidationUtil validationUtil;

  public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
    this.partRepository = partRepository;
    this.modelMapper = modelMapper;
    this.gson = gson;
    this.validationUtil = validationUtil;
  }

  @Override
  public void seedParts() throws IOException {
    if (this.partRepository.count() == 0) {
      String string = Files.readString(Path.of(ProjectConstants.PARTS_INPUT_PATH));
      System.out.println();
    }
  }
}
