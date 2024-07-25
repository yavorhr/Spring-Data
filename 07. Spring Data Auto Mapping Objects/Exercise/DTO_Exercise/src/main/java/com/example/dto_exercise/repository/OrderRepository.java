package com.example.dto_exercise.repository;

import com.example.dto_exercise.model.entity.Order;
import com.example.dto_exercise.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

  List<Order> findOrderByBuyer(User buyer);
}
