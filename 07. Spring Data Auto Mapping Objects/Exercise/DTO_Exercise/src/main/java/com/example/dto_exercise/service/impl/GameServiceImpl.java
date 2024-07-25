package com.example.dto_exercise.service.impl;

import com.example.dto_exercise.model.dto.GameAddDto;
import com.example.dto_exercise.model.dto.view.GameViewDtoTitleAndPrice;
import com.example.dto_exercise.model.dto.view.ViewGameDetailsDto;
import com.example.dto_exercise.model.entity.Game;
import com.example.dto_exercise.model.entity.User;
import com.example.dto_exercise.repository.GameRepository;
import com.example.dto_exercise.repository.UserRepository;
import com.example.dto_exercise.service.GameService;
import com.example.dto_exercise.service.UserService;
import com.example.dto_exercise.userContext.UserContext;
import com.example.dto_exercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
  private final GameRepository gameRepository;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final UserContext userContext;
  private final UserRepository userRepository;

  public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserContext userContext, UserService userService, UserRepository userRepository) {
    this.gameRepository = gameRepository;
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.userContext = userContext;
  }

  @Override
  @Transactional
  public void addGame(GameAddDto gameAddDto) {
    if (this.userContext.getId() == null) {
      System.out.println("You need to be logged in in order to add game!");
      return;
    }

    if (this.gameRepository.findByTitle(gameAddDto.getTitle()).isPresent()) {
      System.out.printf("Game with title %s already exists!\n", gameAddDto.getTitle());
      return;
    }

    Set<ConstraintViolation<GameAddDto>> violation =
            validationUtil.violation(gameAddDto);

    if (!violation.isEmpty()) {
      violation
              .stream()
              .map(ConstraintViolation::getMessage)
              .forEach(System.out::println);
      return;
    }

    Game game = this.modelMapper.map(gameAddDto, Game.class);
    game.setReleaseDate(LocalDate.parse(gameAddDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

    User user = this.userRepository.findById(userContext.getId()).orElse(null);

    game.getUsers().add(user);
    user.getGames().add(game);

    this.gameRepository.save(game);
    this.userRepository.save(user);

    System.out.printf("Added %s\n", game.getTitle());
  }

  @Override
  public void editGame(long gameId, BigDecimal updatedPrice, double updatedSize) {
    Game game = this.gameRepository
            .findById(gameId)
            .orElse(null);

    if (gameNotExisting(game, "There is no game with this ID present!")) {
      return;
    }

    game.setPrice(updatedPrice);
    game.setSize(updatedSize);

    this.gameRepository.save(game);
    System.out.println("Edited " + game.getTitle());
  }

  @Override
  @Transactional
  public void deleteGameById(long gameId) {
    Game game = this.gameRepository
            .findById(gameId)
            .orElse(null);

    if (gameNotExisting(game, "There is no game with this Id!")) {
      return;
    }

    System.out.println("Deleted " + game.getTitle());
    this.gameRepository.deleteById(gameId);
  }

  @Override
  public void printAllGamesTitlesAndPrices() {
    List<GameViewDtoTitleAndPrice> games =
            this.modelMapper.map(this.gameRepository.findAll(),
                    new TypeToken<List<GameViewDtoTitleAndPrice>>() {
                    }.getType());

    games
            .stream()
            .map(g -> String.format("%s - %.2f",
                    g.getTitle(),
                    g.getPrice()))
            .forEach(System.out::println);
  }

  @Override
  public void printGameDetails(String title) {
    Game game = this.gameRepository.findByTitle(title).orElse(null);

    if (gameNotExisting(game, "There is no game with this title!")) {
      return;
    }

    ViewGameDetailsDto gameDto = this.modelMapper.map(game, ViewGameDetailsDto.class);
    gameDto.setReleaseDate(game.getReleaseDate().toString());

    printResult(gameDto);
  }

  // Helpers
  private void printResult(ViewGameDetailsDto gameDto) {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("Title: %s", gameDto.getTitle())).append(System.lineSeparator());
    sb.append(String.format("Price: %.2f", gameDto.getPrice())).append(System.lineSeparator());
    sb.append(String.format("Description: %s", gameDto.getDescription())).append(System.lineSeparator());
    sb.append(String.format("Release date: %s", gameDto.getReleaseDate())).append(System.lineSeparator());

    System.out.println(sb);
  }

  private boolean gameNotExisting(Game game, String message) {
    if (game == null) {
      System.out.println(message);
      return true;
    }
    return false;
  }
}