package com.example.cardealer.repository;

import com.example.cardealer.model.entity.Car;
import com.example.cardealer.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

  Sale findByCar(Car car);
}
