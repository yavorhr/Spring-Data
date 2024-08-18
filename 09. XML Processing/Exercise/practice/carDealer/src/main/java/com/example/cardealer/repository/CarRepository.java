package com.example.cardealer.repository;

import com.example.cardealer.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
