package com.example.dto_exercise.service;

import com.example.dto_exercise.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {

  void addGame(GameAddDto gameAddDto);

  void editGame(long gameId, BigDecimal updatedPrice, double updatedSize);

  void deleteGameById(long gameId);

  void printAllGamesTitlesAndPrices();
}
