package com.example.cardealer_practice.model.repository;

import com.example.cardealer_practice.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

 List<Customer> findAllByOrderByBirthDateAscYoungDriverAsc();
}
