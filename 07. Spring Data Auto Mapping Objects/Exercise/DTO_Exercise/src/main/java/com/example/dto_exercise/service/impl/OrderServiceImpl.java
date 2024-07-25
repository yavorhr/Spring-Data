package com.example.dto_exercise.service.impl;

import com.example.dto_exercise.model.entity.Game;
import com.example.dto_exercise.model.entity.Order;
import com.example.dto_exercise.model.entity.User;
import com.example.dto_exercise.repository.GameRepository;
import com.example.dto_exercise.repository.OrderRepository;
import com.example.dto_exercise.repository.UserRepository;
import com.example.dto_exercise.service.OrderService;
import com.example.dto_exercise.userContext.UserContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
  private final ModelMapper modelMapper;
  private final OrderRepository orderRepository;
  private final UserContext userContext;
  private final UserRepository userRepository;
  private final GameRepository gameRepository;

  public OrderServiceImpl(ModelMapper modelMapper, OrderRepository orderRepository, UserContext userContext, UserRepository userRepository, GameRepository gameRepository) {
    this.modelMapper = modelMapper;
    this.orderRepository = orderRepository;
    this.userContext = userContext;
    this.userRepository = userRepository;
    this.gameRepository = gameRepository;

  }

  @Override
  public void addItem(String gameTitle) {

//    if (!userContext.isUserLoggedIn()) {
//      System.out.println("You need to log in to be able to add game to the shopping cart!");
//      return;
//    }
//
//    User currentUser = this.userRepository
//            .findById(userContext.getId())
//            .orElse(null);
//
//    Game game = this.gameRepository.findByTitle(gameTitle).orElse(null);
//
//    if (currentUser.getGames().contains(game)){
//      System.out.println("You have already add this game to the shopping cart!");
//      return;
//    }
//
//    Order order = new Order();
//
//    order.setBuyer(currentUser);
//    order.getGames().add();
//
//    this.orderRepository.save(order);
  }
}
