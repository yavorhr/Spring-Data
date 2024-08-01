package com.example.cardealer_practice.model.conf;

import com.example.cardealer_practice.model.entity.Customer;
import com.example.cardealer_practice.model.entity.dto.seed.CustomerDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

  @Bean
  public Gson gson() {
    return new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {

      @Override
      public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
        return mappingContext.getSource() == null
                ? LocalDate.now()
                : LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
      }
    };

    modelMapper.addConverter(localDateConverter);

    return modelMapper;
  }

  @Bean
  public BufferedReader bufferedReader() {
    return new BufferedReader(new InputStreamReader(System.in));
  }
}
