package com.example.cardealer.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    Converter<String, LocalDateTime> stringToLocalDateTimeConverter = new Converter<String, LocalDateTime>() {
      @Override
      public LocalDateTime convert(MappingContext<String, LocalDateTime> context) {
        return LocalDateTime.parse(context.getSource(), formatter);
      }
    };

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.addConverter(stringToLocalDateTimeConverter);

    return modelMapper;
  }

  @Bean
  public BufferedReader bufferedReader() {
    return new BufferedReader(new InputStreamReader(System.in));
  }
}
