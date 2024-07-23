package com.example.dto_exercise;

import com.example.dto_exercise.model.dto.UserLoginDto;
import com.example.dto_exercise.model.dto.UserRegisterDto;
import com.example.dto_exercise.service.UserService;
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
      String[] commands = bufferedReader.readLine().split("\\|");

      switch (commands[0]) {
        case "RegisterUser" -> userService.registerUser(new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));
        case "LoginUser" -> this.userService.loginUser(new UserLoginDto(commands[1], commands[2]));
        case "Logout" -> this.userService.logout();
      }
    }

  }
}

