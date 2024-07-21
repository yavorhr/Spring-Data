package com.example.dto_exercise_practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  

  @Override
  public void run(String... args) throws Exception {
    System.out.println("ok");
  }
}
