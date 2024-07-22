package com.example.dto_exercise_practice;

import com.example.dto_exercise_practice.model.dto.RegisterUserDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;

  public CommandLineRunnerImpl(BufferedReader bufferedReader) {
    this.bufferedReader = bufferedReader;
  }

  @Override
  public void run(String... args) throws Exception {

    while (true) {
      System.out.println("Enter your commands: ");
      String[] tokens = bufferedReader.readLine().split("\\|");
      String command = tokens[0];

      switch (command){
        case "RegisterUser" -> {
          RegisterUserDto registerUserDto =
        }
      }
    }
  }
}
