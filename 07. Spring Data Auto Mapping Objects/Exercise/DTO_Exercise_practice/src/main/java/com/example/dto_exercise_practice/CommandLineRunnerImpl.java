package com.example.dto_exercise_practice;

import com.example.dto_exercise_practice.model.dto.RegisterUserDto;
import com.example.dto_exercise_practice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final UserService userService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, UserService userService) {
    this.bufferedReader = bufferedReader;
    this.userService = userService;
  }

  @Override
  public void run(String... args) throws Exception {

    while (true) {
      System.out.println("Enter your commands: ");
      String[] tokens = bufferedReader.readLine().split("\\|");
      String command = tokens[0];

      switch (command) {
        case "RegisterUser" -> userService.registerUser(new RegisterUserDto(tokens[1], tokens[2], tokens[3], tokens[4]));

      }
    }
  }
}
