package com.example.carDealer.domain.repositories;

import com.example.carDealer.domain.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
}
