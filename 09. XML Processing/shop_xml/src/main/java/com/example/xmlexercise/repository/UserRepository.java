package com.example.xmlexercise.repository;

import com.example.xmlexercise.model.entity.Product;
import com.example.xmlexercise.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id AND p.buyer IS NOT NULL)>0 ORDER BY u.lastName,u.firstName")
    List<User> findAllUsersWithMoreThanOneSoldProduct();

    @Query("SELECT u FROM User u WHERE (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id )>0 ORDER BY u.soldProducts.size DESC,u.lastName")
    List<User> findAllUsersWithAtLeastOneProductSold();
}
