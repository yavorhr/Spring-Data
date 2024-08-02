package com.example.mappingobjectslab.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationBeanConf {

  @Bean
  public Scanner scanner() {
    return new Scanner(System.in);
  }


  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
