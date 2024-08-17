package com.example.cardealer.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
}
