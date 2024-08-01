package com.example.cardealer_practice.model.repository;

import com.example.cardealer_practice.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
  List<Supplier> findAllByImporterFalse();
}
