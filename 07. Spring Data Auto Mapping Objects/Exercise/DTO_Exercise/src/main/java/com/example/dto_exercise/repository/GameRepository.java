package com.example.dto_exercise.repository;

import com.example.dto_exercise.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  Optional<Game> findByTitle(String title);


}
