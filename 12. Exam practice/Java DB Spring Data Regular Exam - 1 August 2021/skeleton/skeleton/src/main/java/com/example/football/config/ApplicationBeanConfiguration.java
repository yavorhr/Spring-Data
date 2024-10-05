package com.example.football.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationBeanConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

//    modelMapper.addConverter(new Converter<String, LocalDate>() {
//      @Override
//      public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
//        return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//      }
//    });
    return modelMapper;
  }

}

