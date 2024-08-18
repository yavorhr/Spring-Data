package com.example.cardealer.repository;

import com.example.cardealer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query("Select c from Customer  c ORDER BY c.birthDate ASC, c.isYoungDriver ASC")
  List<Customer> findAllCustomersOrderedByBirthdayAndExperience();

}
