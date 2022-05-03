package com.example.carDealer.domain.repositories;

import com.example.carDealer.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
