package com.example.dto_exercise.service.impl;

import com.example.dto_exercise.model.entity.Game;
import com.example.dto_exercise.model.entity.ShoppingCart;
import com.example.dto_exercise.model.entity.User;
import com.example.dto_exercise.repository.GameRepository;
import com.example.dto_exercise.repository.ShoppingCartRepository;
import com.example.dto_exercise.repository.UserRepository;
import com.example.dto_exercise.service.ShoppingCartService;
import com.example.dto_exercise.userContext.UserContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {
  private final UserContext userContext;
  private final ShoppingCartRepository shoppingCartRepository;
  private final UserRepository userRepository;
  private final GameRepository gameRepository;

  public ShoppingCartServiceImpl(UserContext userContext, ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, GameRepository gameRepository) {
    this.userContext = userContext;
    this.shoppingCartRepository = shoppingCartRepository;
    this.userRepository = userRepository;
    this.gameRepository = gameRepository;
  }

  @Override
  @Transactional
  public void addItem(String gameTitle) {
    if (!this.userContext.isUserLoggedIn()) {
      System.out.println("PLease login to be able to add game to the shopping cart!");
      return;
    }

    if (this.shoppingCartRepository.doesGameExistInShoppingCart(gameTitle) > 0) {
      System.out.println("Game is already added in the shopping cart!");
      return;
    }

    User user = this.userRepository.findById(this.userContext.getId()).orElse(null);
    Game game = this.gameRepository.findByTitle(gameTitle).orElse(null);

    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setUser(user);
    shoppingCart.getAddedGames().add(game);

    this.shoppingCartRepository.save(shoppingCart);
  }
}
