package com.example.mappingobjectslab.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
  public Gson gson() {
    return new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
  }
}
