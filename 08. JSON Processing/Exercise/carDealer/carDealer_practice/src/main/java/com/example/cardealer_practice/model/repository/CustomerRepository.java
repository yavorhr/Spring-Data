package com.example.cardealer_practice.model.repository;

import com.example.cardealer_practice.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findAllByOrderByBirthDateAscYoungDriverAsc();

  @Query("SELECT c FROM Customer c WHERE SIZE(c.sales) > 0")
  Set<Customer> findAllByBoughtCars();
}
