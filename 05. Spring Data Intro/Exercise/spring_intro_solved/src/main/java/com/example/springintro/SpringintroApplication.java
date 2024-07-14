package com.example.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//От тук стартираме нашето приложение. SpringIntro-Application е винаги началната точка

@SpringBootApplication
public class SpringintroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringintroApplication.class, args);
    }

}
