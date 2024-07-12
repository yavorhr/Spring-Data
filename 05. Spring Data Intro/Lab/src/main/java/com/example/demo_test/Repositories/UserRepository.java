package com.example.demo_test.Repositories;

import com.example.demo_test.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   boolean existsByUsername(String username);
   
}
