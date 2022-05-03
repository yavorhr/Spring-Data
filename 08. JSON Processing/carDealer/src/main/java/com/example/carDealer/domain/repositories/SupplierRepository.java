package com.example.carDealer.domain.repositories;

import com.example.carDealer.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

  Set<Supplier> findAllByImporter(boolean isImporter);
}
