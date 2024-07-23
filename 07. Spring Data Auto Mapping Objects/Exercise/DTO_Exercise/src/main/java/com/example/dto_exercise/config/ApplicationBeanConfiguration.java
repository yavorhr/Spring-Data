package com.example.dto_exercise.config;


import com.example.dto_exercise.model.dto.GameAddDto;
import com.example.dto_exercise.model.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

  @Bean
  public BufferedReader bufferedReader() {
    return new BufferedReader(new InputStreamReader(System.in));
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper.
            typeMap(GameAddDto.class, Game.class)
            .addMappings(mapper ->
                    mapper.map(GameAddDto::getThumbnail,
                            Game::setImageThumbnail));

//    Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
//
//      @Override
//      public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
//        return mappingContext.getSource() == null
//                ? LocalDate.now()
//                : LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//      }
//    };
//
//    modelMapper.addConverter(localDateConverter);

    return modelMapper;
  }
}
