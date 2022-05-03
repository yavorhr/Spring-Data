package com.example.carDealer.domain.repositories;

import com.example.carDealer.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Set<Customer> getAllByOrderByBirthDateAscYoungDriverAsc();


    @Query("SELECT c FROM Customer c " +
            "WHERE c.sales.size > 0")
    Set<Customer> getAllByBoughtCars();
}
