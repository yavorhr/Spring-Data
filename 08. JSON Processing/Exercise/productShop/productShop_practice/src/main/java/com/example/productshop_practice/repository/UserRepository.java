package com.example.productshop_practice.repository;

import com.example.productshop_practice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT u FROM User u " +
          "WHERE (SELECT Count(p) FROM Product p WHERE  p.seller.id = u.id) >0 ORDER BY u.lastName,u.firstName")
  List<User> findAllUsersWithMoreThanOneSoldProductsOrderByLastNameThanFirstName();

  @Query("SELECT u  FROM User u WHERE SIZE(u.soldProducts)>0 ORDER BY SIZE(u.soldProducts) DESC, u.lastName ASC")
  List<User> findAllBySoldProductsCount();
}
