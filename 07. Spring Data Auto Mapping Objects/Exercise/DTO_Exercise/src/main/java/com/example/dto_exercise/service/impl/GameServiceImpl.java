package com.example.dto_exercise.service.impl;

import com.example.dto_exercise.model.dto.GameAddDto;
import com.example.dto_exercise.model.dto.GameViewDtoTitleAndPrice;
import com.example.dto_exercise.model.entity.Game;
import com.example.dto_exercise.repository.GameRepository;
import com.example.dto_exercise.service.GameService;
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

  public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
    this.gameRepository = gameRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public void addGame(GameAddDto gameAddDto) {
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
//    game.setImageThumbnail(gameAddDto.getThumbnail());
    this.gameRepository.save(game);

    System.out.printf("Added %s\n", game.getTitle());
  }

  @Override
  public void editGame(long gameId, BigDecimal updatedPrice, double updatedSize) {
    Game game = this.gameRepository
            .findById(gameId)
            .orElse(null);

    if (game == null) {
      System.out.println("There is no game with this ID present!");
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

    if (game == null) {
      System.out.println("There is no game with this ID present!");
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
}
