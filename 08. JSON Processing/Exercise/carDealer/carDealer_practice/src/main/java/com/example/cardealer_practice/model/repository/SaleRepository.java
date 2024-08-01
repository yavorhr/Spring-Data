package com.example.cardealer_practice.model.repository;

import com.example.cardealer_practice.model.entity.Car;
import com.example.cardealer_practice.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

  Optional<Sale> findByCar(Car car);
}
