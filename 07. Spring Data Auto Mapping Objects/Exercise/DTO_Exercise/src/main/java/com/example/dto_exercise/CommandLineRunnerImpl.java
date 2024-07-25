package com.example.dto_exercise;

import com.example.dto_exercise.model.dto.GameAddDto;
import com.example.dto_exercise.model.dto.UserLoginDto;
import com.example.dto_exercise.model.dto.UserRegisterDto;
import com.example.dto_exercise.service.GameService;
import com.example.dto_exercise.service.OrderService;
import com.example.dto_exercise.service.UserService;
import com.example.dto_exercise.userContext.UserContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
  private final BufferedReader bufferedReader;
  private final UserService userService;
  private final GameService gameService;
  private final OrderService orderService;

  public CommandLineRunnerImpl(BufferedReader bufferedReader, UserService userService, GameService gameService, UserContext userContext, OrderService orderService) {
    this.bufferedReader = bufferedReader;
    this.userService = userService;
    this.gameService = gameService;
    this.orderService = orderService;
  }

  @Override
  public void run(String... args) throws Exception {
    while (true) {
      System.out.println("Enter your commands: ");
      String[] tokens = bufferedReader.readLine().split("\\|");

      switch (tokens[0]) {
        case "RegisterUser" -> userService.registerUser(new UserRegisterDto(tokens[1], tokens[2], tokens[3], tokens[4]));
        case "LoginUser" -> this.userService.loginUser(new UserLoginDto(tokens[1], tokens[2]) );
        case "Logout" -> this.userService.logout();
        case "DeleteUser" -> this.userService.deleteUser(Long.parseLong(tokens[1]));
        case "AddGame" -> this.gameService.addGame(
                new GameAddDto(tokens[1],
                        new BigDecimal(tokens[2]),
                        Double.parseDouble(tokens[3]),
                        tokens[4],
                        tokens[5],
                        tokens[6],
                        tokens[7]));
        case "EditGame" -> {
          BigDecimal price = BigDecimal.valueOf(Double.parseDouble(tokens[2].split("=")[1]));
          double size = Double.parseDouble(tokens[3].split("=")[1]);

          gameService.editGame(
                  Long.parseLong(tokens[1]),
                  price,
                  size);
        }
        case "DeleteGame" -> this.gameService.deleteGameById(Long.parseLong(tokens[1]));
        case "AllGames" -> this.gameService.printAllGamesTitlesAndPrices();
        case "DetailGame" -> this.gameService.printGameDetails(tokens[1]);
        case "OwnedGames" -> this.userService.printGamesByUserId();
        case "AddItem" -> this.orderService.addItem(tokens[1]);
      }
    }

  }
}

