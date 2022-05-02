package com.example.dtoex.service;

import com.example.dtoex.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long gameId, BigDecimal price, double size);
}
