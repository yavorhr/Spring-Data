package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBeanConfiguration {

  @Bean
  public Gson gson() {
    return new GsonBuilder()
            .setPrettyPrinting()
            .create();
  }

}
