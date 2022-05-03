package com.example.jsonexercie.repository;

import com.example.jsonexercie.model.Entity.User;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmPrimitiveArrayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT Count(p) FROM Product p WHERE  p.seller.id = u.id) >0 ORDER BY u.lastName,u.firstName")
    List<User> findAllUsersWithMoreThanOneSoldProductsOrderByLastNameThanFirstName();
}
