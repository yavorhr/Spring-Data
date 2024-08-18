package com.example.cardealer.repository;

import com.example.cardealer.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

  @Query("select s from Supplier s where s.isImporter = false ")
  List<Supplier> findAllByImporterFalse();
}


