package com.example.dto_exercise.service.impl;

import com.example.dto_exercise.model.entity.User;
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

  public OrderServiceImpl(ModelMapper modelMapper, OrderRepository orderRepository, UserContext userContext, UserRepository userRepository) {
    this.modelMapper = modelMapper;
    this.orderRepository = orderRepository;
    this.userContext = userContext;
    this.userRepository = userRepository;
  }

  @Override
  public void addItem(String gameTitle) {
    User user = this.modelMapper.map(this.userContext, User.class);
  }
}
