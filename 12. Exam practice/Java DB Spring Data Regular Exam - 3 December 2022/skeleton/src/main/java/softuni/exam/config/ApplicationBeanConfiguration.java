package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ApplicationBeanConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.addConverter(new Converter<String, LocalDateTime>() {
      @Override
      public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
        return LocalDateTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      }
    });
    return modelMapper;
  }

  @Bean
  public Gson gson() {
    return new GsonBuilder()
            .setPrettyPrinting()
            .create();
  }
}
