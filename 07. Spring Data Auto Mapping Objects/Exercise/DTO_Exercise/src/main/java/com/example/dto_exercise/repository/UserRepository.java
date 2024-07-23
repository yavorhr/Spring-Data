package com.example.dto_exercise.repository;

import com.example.dto_exercise.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT COUNT(u)  FROM User u WHERE u.admin = true")
  long countAdmins();

  Optional<User> findUserByEmailAndPassword(String email, String password);

  Optional<User> findUserByEmail(String email);


}


